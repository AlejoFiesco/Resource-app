package com.example.demo.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Classroom;

@Service
public interface ClassroomBusinessInt {
	public Classroom createClassroom(Classroom classroom) throws Exception;
	public List<Classroom> getClassroomList() throws Exception;
	Classroom getClassroomById(String classroomId) throws Exception;
}
