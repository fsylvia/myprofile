package com.raje.myprofile.service;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raje.myprofile.model.D3Skills;
import com.raje.myprofile.model.Profile;
import com.raje.myprofile.model.Project;
import com.raje.myprofile.model.Skill;

@Service
public class PropertyService {
	Logger logger = Logger.getLogger(PropertyService.class.getName());

	Resource jsonFile = new ClassPathResource("profile.json");

	/**
	 * Populate {@link Profile} object from JSON
	 * @return {@link Profile}
	 * @throws IOException
	 * 
	 */
	public Profile getProfileData() throws IOException {
		//todo : add exception handling
		logger.info("Invoking getProfileData()");
		ObjectMapper objectMapper = new ObjectMapper();
		Profile profile = objectMapper.readValue(jsonFile.getFile(), Profile.class);
		logger.info("Profile object created : " + profile.toString());
		return profile;
	}
	
	//todo: move to date utils
	public static float getDiffInYear(String fromMonthYear, String toMonthYear) {
	    DateTimeFormatter monthYearFormat = DateTimeFormatter.ofPattern("MMMM uuuu");
	    YearMonth from = YearMonth.parse(fromMonthYear, monthYearFormat);
	    YearMonth to   = YearMonth.parse(toMonthYear  , monthYearFormat);
	    long months = from.until(to, ChronoUnit.MONTHS);
	    return months;
	}
	
	public List<Skill> getSkills(Profile profile) {
		List<Skill> skillSet = new ArrayList<>();
		List<Project> projects = new ArrayList<Project>();
		profile.getCompany().forEach((organization) -> {
			projects.addAll(organization.getProject());
		});
		for (Project project : projects) {
			Float year = getDiffInYear(project.getFrom(), project.getTo());
			for (Skill skill : project.getSkill()) {
				if (skillSet.contains(skill)) {
					skillSet.get(skillSet.indexOf(skill)).addSize(year);
				} else {
					skill.setSize(year);
					skillSet.add(skill);
				}
			}
		}
		return skillSet;
	}
	
	public D3Skills formatSkills(Profile profile) {
		
		D3Skills skillsRoot = new D3Skills("Skills", null);
		List<Skill> skills = getSkills(profile);
		for (Skill skill : skills) {
			String [] grpName = skill.getType().split("-");
			D3Skills root = skillsRoot;
			for(int i=0; i<grpName.length;i++) {
				D3Skills node = root.findNode(grpName[i]);
				if(node==null) {
					node = new D3Skills(grpName[i], null);
					root.addChild(node);
				}
				
				root = node;
			}
			D3Skills child = new D3Skills(skill.getName(), skill.getSize());
			root.addChild(child);
		}
		
		return skillsRoot;
	}
	
	public String skillsToJson(Profile profile) {
		D3Skills skills = formatSkills(profile);
		//System.out.println(skills);
		String skillJson = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			skillJson = mapper.writeValueAsString(skills);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println(skillJson);
			e.printStackTrace();
		}
		System.out.println(skillJson);
		return skillJson;
	}
	
	

	
}
