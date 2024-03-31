package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ClassroomBusinessImp;
import com.example.demo.model.Classroom;
import com.example.demo.services.interfaces.ClassroomServiceInt;
import com.example.demo.utilities.responses.CustomResponse;

@RestController
public class ClassroomServiceImp implements ClassroomServiceInt{

	@Autowired
	ClassroomBusinessImp classroomBusiness;
	
	@Override
	public ResponseEntity<Classroom> createClassroom(Classroom classroom) {
		Classroom createdClassroom = null;
		try {
			createdClassroom = classroomBusiness.createClassroom(classroom);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(createdClassroom);
	}

	@Override
	public ResponseEntity<List<Classroom>> getClassroom() {
		List<Classroom> classroomList = null;
		try {
			classroomList = classroomBusiness.getClassroomList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return CustomResponse.buildResponse(classroomList);
	}

	@Override
	public ResponseEntity<Classroom> getClassroomById(String classroomId) {
		Classroom returnedClassroom = null;
		
		try {
			returnedClassroom = classroomBusiness.getClassroomById(classroomId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(returnedClassroom);
	}

}
