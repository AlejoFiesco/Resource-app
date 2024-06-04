package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.model.catalog.UserType;

public interface UserBusinessInt {

	public User createUser(User user) throws Exception;
	public List<User> getUserList() throws Exception;
	public User getUserById(String id) throws Exception;
	public List<UserType> getUserTypes() throws Exception;
	public UserType createUserType(UserType userType) throws Exception;
}
