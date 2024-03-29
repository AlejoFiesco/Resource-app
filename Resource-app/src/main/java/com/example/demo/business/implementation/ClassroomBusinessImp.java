package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ClassroomBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.model.Classroom;

@Service
public class ClassroomBusinessImp implements ClassroomBusinessInt {

	@Autowired
	Factory factory;

	@Override
	public Classroom createClassroom(Classroom classroom) throws Exception {
		Classroom createdClassroom = null;
		if (classroom != null) {
			try {
				createdClassroom = (Classroom) factory.create(classroom);
			} catch (Exception e) {
				throw e;
			}
		}
		return createdClassroom;
	}

	@Override
	public List<Classroom> getClassroomList() throws Exception {
		List<Classroom> classroomList = null;

		try {
			classroomList = factory.getList(Classroom.class);
		} catch (Exception e) {
			throw e;
		}
		return classroomList;
	}
}
