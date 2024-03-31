package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.User;

public interface UserBusinessInt {

	public User createUser(User user) throws Exception;
	public List<User> getUserList() throws Exception;
	public User getUserById(String id) throws Exception;
}
