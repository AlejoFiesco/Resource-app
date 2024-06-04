package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.config.AuthenticatorAnnotation;
import com.example.demo.model.User;
import com.example.demo.model.catalog.UserType;

@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST})
public interface UserServiceInt {

	@PostMapping("/")
	@AuthenticatorAnnotation
	public ResponseEntity<User> createUser(@RequestBody User user);
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers();
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(value="userId") String id);
	
	@GetMapping("/types")
	public ResponseEntity<UserType> getUserTypes();
	
	@PostMapping("/")
	@AuthenticatorAnnotation
	public ResponseEntity<UserType> createUserType(@RequestBody UserType userType);
	
}
