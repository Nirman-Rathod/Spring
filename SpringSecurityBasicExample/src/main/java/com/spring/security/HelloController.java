package com.spring.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(Model model) {
		model.addAttribute("message", "Spring Security says Hello !");
		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogoutPage(Model model, HttpServletRequest req) {
		req.getSession().invalidate();
		return "logout";
	}
}
