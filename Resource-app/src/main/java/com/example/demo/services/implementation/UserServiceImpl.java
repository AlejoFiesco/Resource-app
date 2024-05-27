package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.UserBusinessImpl;
import com.example.demo.config.AuthenticatorAnnotation;
import com.example.demo.model.User;
import com.example.demo.services.interfaces.UserServiceInt;
import com.example.demo.utilities.responses.CustomResponse;

@RestController
public class UserServiceImpl implements UserServiceInt{

	@Autowired
	UserBusinessImpl userBusiness;
	
	@Override
	@AuthenticatorAnnotation
	public ResponseEntity<User> createUser(User user) {
		User newUser = null;
		
		if(user != null) {
			try {
				newUser = userBusiness.createUser(user);				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return CustomResponse.buildResponse(newUser);
	}

	@Override
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList = null;
		try {
			userList = userBusiness.getUserList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(userList);
	}

	@Override
	public ResponseEntity<User> getUserById(String id) {
		User user = null;
		try {
			user = userBusiness.getUserById(id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(user);
	}

}
