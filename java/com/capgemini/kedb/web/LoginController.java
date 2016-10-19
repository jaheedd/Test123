package com.capgemini.kedb.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request,
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password
			) {
		
		return new ModelAndView("redirect:dashboard.html");
		//return new ModelAndView("redirect:maineDurables.html");
		
	}

	/*
	 * @RequestMapping("/greeting") public String
	 * greeting(@RequestParam(value="name", defaultValue="World") String name) {
	 * return "Greetings"; }
	 */

}
