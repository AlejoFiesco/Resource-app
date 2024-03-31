package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;

@RequestMapping("/user")
public interface UserServiceInt {

	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user);
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers();
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(value="userId") String id);
	
}
