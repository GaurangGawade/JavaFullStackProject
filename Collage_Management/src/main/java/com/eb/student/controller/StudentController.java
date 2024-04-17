package com.eb.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eb.student.model.Student;
import com.eb.student.service.StudentService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "user")
public class StudentController {
	@Autowired
	StudentService service;
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
	
		return service.createStudent(student);
		
	}
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Student updateStudent(@PathVariable ("id")int id,@RequestBody Student s) {
		s.setId(id);
		return service.updateStudent(s);
		
	}
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Student> getAllStudent() 
	{
		return service.getAllStudent();
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)

	public String deleteStudent (@PathVariable("id")int id) 
 
	{
		return service.deleteStudent(id);
		
	}
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Student getStudentById(@PathVariable("id")int id)
	{
		return service.getStudentById(id);
		
	}
}
