package com.raje.myprofile.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.raje.myprofile.exception.ServiceException;
import com.raje.myprofile.model.Company;
import com.raje.myprofile.model.D3Skills;
import com.raje.myprofile.model.Profile;
import com.raje.myprofile.model.Project;
import com.raje.myprofile.model.Skill;

/**
 * Tests the PropertyService class
 * todo : add negative test cases
 * 
 * @author fsylvia
 *
 */
public class PropertyServiceTest {
	PropertyService service = null;

	@Before
	public void init() {
		service = new PropertyService();
	}

	@Test
	public void testGetProfileData() throws ServiceException {
		Profile profile = service.getProfileData();
		assertThat(profile).isNotNull();
	}

	@Test
	public void testFormatSkills() {

		Profile profile = buildProfile();

		PropertyService service = new PropertyService();
		String d3Skills = service.formatSkills(profile).toString();
		assertTrue("CI occurs more than once : ", (StringUtils.countMatches(d3Skills, "CI")) == 1);
		assertTrue("Tools occurs more than once : ", (StringUtils.countMatches(d3Skills, "Tools")) == 1);
		assertTrue("Build occurs more than once : ", (StringUtils.countMatches(d3Skills, "Build")) == 1);
		assertTrue("Language occurs more than once : ", (StringUtils.countMatches(d3Skills, "Language")) == 1);
	}

	private Profile buildProfile() {
		List<Skill> skills = new ArrayList<>();
		String[] skillGroup = { "Tools-CI", "Tools-CI", "Tools-Build", "Tools-Build", "Language" };
		String[] skillName = { "CodePro", "Sonarqube", "Maven", "Ant", "Java" };

		for (int i = 0; i < skillGroup.length; i++) {
			skills.add(i, new Skill());
			skills.get(i).setType(skillGroup[i]);
			skills.get(i).setName(skillName[i]);
		}

		Project project = new Project();
		project.setFrom("August 2004");
		project.setTo("September 2006");
		project.setSkill(skills);
		Profile profile = new Profile();
		Company company = new Company();

		company.setProject(new ArrayList<Project>());
		company.getProject().add(project);
		profile.setCompany(new ArrayList<Company>());
		profile.getCompany().add(company);
		return profile;
	}

	public D3Skills getMockSkill() {

		// add database
		D3Skills sonar = new D3Skills("Sonarqube", 5f);
		D3Skills cPro = new D3Skills("CodePro", 2f);
		D3Skills CI = new D3Skills("CI", null);
		CI.addChild(sonar);
		CI.addChild(cPro);
		D3Skills tools = new D3Skills("Tools", null);
		tools.addChild(CI);

		// add build tools
		D3Skills maven = new D3Skills("Ant", 3f);
		D3Skills ant = new D3Skills("Maven", 1f);
		D3Skills build = new D3Skills("Build", null);
		build.addChild(maven);
		build.addChild(ant);
		tools.addChild(build);

		D3Skills skills = new D3Skills("Skills", null);
		skills.addChild(tools);
		return skills;

	}

	@Test
	public void testFindNode() {
		D3Skills skills = getMockSkill();
		D3Skills childNode = skills.findNode("CI");
		System.out.println(childNode);
		assertTrue("skill CI not found", childNode != null);

		assertTrue("skill Sonarqube not found", skills.findNode("Sonarqube") != null);
		assertTrue("skill Tools not found", skills.findNode("Tools") != null);
		assertTrue("skill Maven not found", skills.findNode("Maven") != null);
		assertTrue("skill Build not found", skills.findNode("Build") != null);
		assertTrue("skill Test not found", skills.findNode("Test") == null);

	}
	
	@After
	public void destroy() {
		service = null;
	}

}
