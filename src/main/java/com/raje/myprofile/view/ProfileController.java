package com.raje.myprofile.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raje.myprofile.exception.ServiceException;
import com.raje.myprofile.model.Profile;
import com.raje.myprofile.service.PropertyService;

@Controller
public class ProfileController {
	Logger logger = Logger.getLogger(ProfileController.class.getName());
	@Autowired
	PropertyService service;

	@GetMapping("/home")
	public String getHomePage(Model model) throws ServiceException {
		logger.info("Calling method getHomePage");
		Profile profile = null;
		String result;
		String d3SkillData = "";

		profile = service.getProfileData();
		d3SkillData = service.skillsToJson(profile);
		model.addAttribute("profile", profile);
		model.addAttribute("skill", d3SkillData);
		logger.info("Profile Data : " + profile.toString());
		logger.info("Skill Data : " + d3SkillData.toString());
		result = "home";
		return result;
	}

	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		logger.log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + ex);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.setViewName("error");
		return mav;
	}

}
