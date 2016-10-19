package com.capgemini.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.constants.Status;
import com.capgemini.dao.UserDao;
import com.capgemini.entity.User;
import com.capgemini.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements
		AuthenticationService {

	private Logger logger = Logger
			.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateUser(String userId, String password) {
		try {
			User user = userDao.findByUserIdAndStatus(userId, Status.Active);
			if (user != null && password.equals(user.getPassword())) {
				return user;
			}
		} catch (Exception e) {
			logger.error("Exception while authenticating the User:", e);

		}
		return null;
	}
}
