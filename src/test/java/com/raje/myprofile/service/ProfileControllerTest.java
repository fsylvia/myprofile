package com.raje.myprofile.service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.raje.myprofile.model.Company;
import com.raje.myprofile.model.Profile;
import com.raje.myprofile.model.Project;
import com.raje.myprofile.model.Skill;
import com.raje.myprofile.view.ProfileController;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {
	private Profile profile = null;
	private String mockJson = null;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PropertyService profileService;

	@Before
	public void init() {
		List<Skill> skills = new ArrayList<>();
		Project project = new Project();
		project.setFrom("August 2004");
		project.setTo("September 2006");
		project.setSkill(skills);
		profile = new Profile();
		Company company = new Company();

		company.setProject(new ArrayList<Project>());
		company.getProject().add(project);
		profile.setCompany(new ArrayList<Company>());
		profile.getCompany().add(company);

		mockJson = "";
	}

	@Test
	public void testGetHomePage() throws Exception {
		when(profileService.getProfileData()).thenReturn(profile);
		when(profileService.skillsToJson(profile)).thenReturn(mockJson);
		this.mockMvc.perform(get("/home")).andExpect(status().isOk()).andExpect(view().name("home"))
				.andExpect((model().attribute("profile", profile))).andExpect((model().attribute("skill", mockJson)));
	}
}
