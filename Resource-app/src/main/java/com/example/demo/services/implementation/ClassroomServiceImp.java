package com.example.demo.services.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Classroom;
import com.example.demo.services.interfaces.ClassroomServiceInt;

@RestController
public class ClassroomServiceImp implements ClassroomServiceInt{

	@Override
	public ResponseEntity<Classroom> createClassroom(Classroom classroom) {
		
		return ResponseEntity.ok(classroom);
	}

	@Override
	public ResponseEntity<String> getClassroom() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok("Working!!");
	}

}
