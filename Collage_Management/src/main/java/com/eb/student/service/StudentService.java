package com.eb.student.service;

import java.util.List;

import com.eb.student.model.Student;



public interface StudentService {

	Student createStudent(Student s);
	Student updateStudent(Student s);
	List<Student>getAllStudent();
	Student getStudentById(int id);
	String deleteStudent(int id);
	
}
