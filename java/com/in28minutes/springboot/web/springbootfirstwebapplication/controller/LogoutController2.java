package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("name")
public class LogoutController2 {
		
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}*/
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String showWelcomePage(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
	
		return "redirect:/";
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
