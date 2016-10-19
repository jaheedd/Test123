package com.capgemini.kedb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.constants.Constants;
import com.capgemini.constants.GlobalResponse;
import com.capgemini.constants.RequestStatus;
import com.capgemini.entity.User;
import com.capgemini.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	private Logger logger = Logger.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping("/authenticate")
	public GlobalResponse authenticate(
			HttpServletRequest request,
			@NotNull @RequestParam(value = "userId", defaultValue = "") String userId,
			@NotNull @RequestParam(value = "password", defaultValue = "") String password) {

		GlobalResponse response = new GlobalResponse();
		try {
			User user = authenticationService.authenticateUser(userId,
					password);
			if (user != null) {
				response.setStatus(RequestStatus.STATUS_SUCCESS);
				HttpSession session = request.getSession();
				session.setAttribute(Constants.SESSION_ID, user.getId());
				session.setAttribute(Constants.SESSION_USER_ID, userId);
				session.setAttribute(Constants.SESSION_USER_ROLE, user.getRole());
			} else {
				response.setStatus(RequestStatus.STATUS_FAILURE);
				response.setStatusDesc("Login Name or Password wrong");
			}
		} catch (Exception e) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while authenticating");
			logger.error(e);
		}
		return response;
	}

	@RequestMapping("/validateSession")
	public String validateSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping("/logoffUser")
	public void logoffUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
