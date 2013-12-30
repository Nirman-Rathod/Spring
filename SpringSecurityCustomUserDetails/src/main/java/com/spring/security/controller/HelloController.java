package com.spring.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.security.domain.MyUser;
import com.spring.security.service.IUserService;

@Controller
public class HelloController {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
	public String printWelcomeUser() {
		return "hello";
	}

	@RequestMapping(value = "/admin/welcome", method = RequestMethod.GET)
	public String printWelcomeAdmin() {
		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return "hello";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String getFailurePage(Model model) {
		return "failure";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogoutPage(Model model, HttpServletRequest req) {
		req.getSession().invalidate();
		return "logout";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	String saveUser(@RequestBody MyUser user, HttpServletResponse response) {
		System.out.println("User:" + user.getUsername());
		userService.saveUser(user);
		response.setStatus(201);
		return "success";
	}
}
