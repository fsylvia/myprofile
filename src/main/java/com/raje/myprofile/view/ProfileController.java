package com.raje.myprofile.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.raje.myprofile.model.Profile;
import com.raje.myprofile.service.PropertyService;

@Controller
public class ProfileController {
	Logger logger = Logger.getLogger(ProfileController.class.getName());
	@Autowired
	PropertyService service;

	@GetMapping("/home")
	public String getHomePage(Model model) {
		logger.info("Calling method getHomePage");
		Profile profile = null;
		String result;
		String d3SkillData = "";
		try {
			profile = service.getProfileData();
			d3SkillData = service.skillsToJson(profile);
			model.addAttribute("profile", profile);
			model.addAttribute("skill", d3SkillData);
			logger.info("Profile Data : " + profile.toString());
			logger.info("Skill Data : " + d3SkillData.toString());
			result = "home";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception when getting profile data", e);
			result = "error";
		}

		return result;
	}

}
