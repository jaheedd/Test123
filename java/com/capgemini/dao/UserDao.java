package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.constants.Status;
import com.capgemini.entity.Role;
import com.capgemini.entity.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByUserId(String userId);

	public User findByUserIdAndStatus(String userId, Status status);
	
	public Iterable<User> findByStatus(Status status);
	
	public Iterable<User> findByRoleAndStatus(Role role, Status status);
		
	public Iterable<User> findByRoleAndStatusAndUserIdStartingWith(Role role, Status status, String userId);
	
	public User findByEmpNo(String empNo);

	public User findByEmailId(String emailId);

	public Iterable<User> findByRole(Role role);

}