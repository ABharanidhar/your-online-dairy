package com.ab.myonlinedairy.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ab.myonlinedairy.entity.User;
import com.ab.myonlinedairy.service.UserService;
import com.ab.myonlinedairy.user.CrmUser;

@Controller
public class LoginRegisterController {

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/")
	public String displayHomePage() {
		return "redirect:dairy/home";
	}

	@GetMapping("/login")
	public String showMyLoginPage() {
		return "login-form";
	}

	@GetMapping("/register")
	public String showMyRegistrationPage(Model theModel) {

		theModel.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult, Model model) {

		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		if (theBindingResult.hasErrors()) {
			return "registration-form";
		}

		User existing = userService.findByUserName(userName);
		if (existing != null) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			return "registration-form";
		}

		userService.save(theCrmUser);

		logger.info("Successfully created user: " + userName);

		model.addAttribute("registrationMessage", "Successfully Registered. Please logIn to continue");	
		
		return "redirect:login";
	}
	
	/*
	 * @RequestMapping("/error") public String showCommonErrorPage() { return
	 * "error"; }
	 */
}
