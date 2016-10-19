package com.capgemini.service;

import com.capgemini.entity.User;

public interface AuthenticationService {

	public User authenticateUser(String userId, String password);

}
