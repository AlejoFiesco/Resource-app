package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.UserBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.model.User;
import com.example.demo.model.catalog.UserType;

@Service
public class UserBusinessImpl implements UserBusinessInt{

	@Autowired
	Factory factory;

	@Override
	public User createUser(User user) throws Exception {
		User newUser = null;
		
		try {
			newUser = factory.create(user, user.getId());
		}catch(Exception e) {
			throw e;
		}
		
		return newUser;
	}

	@Override
	public List<User> getUserList() throws Exception {
		List<User> userList = null;
		
		try {
			userList = factory.getList(User.class, null);
		}catch(Exception e) {
			throw e;
		}
		
		return userList;
	}

	@Override
	public User getUserById(String id) throws Exception {
		User user = null;
		
		try {
			user = factory.getById(User.class, id);
		}catch(Exception e) {
			throw e;
		}
		
		return user;
	}

	@Override
	public List<UserType> getUserTypes() throws Exception {
		return factory.getList(UserType.class, null);
	}

	@Override
	public UserType createUserType(UserType userType) throws Exception {
		return factory.create(userType, null);
	}
	

}
