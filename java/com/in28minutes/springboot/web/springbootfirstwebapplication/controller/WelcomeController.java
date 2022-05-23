package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("name")
public class WelcomeController {
		
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUserName());
		return "welcome";
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String password, @RequestParam String name, ModelMap model) {
		boolean isValidUser = service.validateUser(name, password);
		
		if(!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		//model.put("password", password);
		
		return "welcome";
	}*/
	
	

	/*@RequestMapping("/login")
	//@ResponseBody, used to just return what is in this function instead of resolving to the "View"
	public String loginMessage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "login";
	}*/
	
}
