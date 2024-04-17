package com.eb.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.student.exception.StudentResource;
import com.eb.student.model.Student;
import com.eb.student.repository.StudentRepository;




@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	
	StudentRepository repo;
	
	
	@Override
	public Student createStudent(Student s) {
		
		return repo.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		
		Optional<Student>student=repo.findById(s.getId());
		if(student.isPresent()) {
			Student updateStudent=student.get();
			updateStudent.setId(s.getId());
			updateStudent.setFirstName(s.getFirstName());
			updateStudent.setLastName(s.getLastName());
			//updateUser.setUsername(u.getUsername());
			updateStudent.setPassword(s.getPassword());
			updateStudent.setGender(s.getGender());
			updateStudent.setCourse(s.getCourse());
			updateStudent.setPhone_no(s.getPhone_no());
			updateStudent.setEmail(s.getEmail());
			repo.save(updateStudent);
			return updateStudent;
			
		}else {
			throw new StudentResource("Searching id not available");
		}
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		
		Optional<Student>student=repo.findById(id);
		if(student.isPresent()) {
			return student.get();		
			}
		else {
			throw new StudentResource("Searching id not available");
		}
	}

	@Override
	public String deleteStudent(int id) {
		
		Optional<Student>student=repo.findById(id);
		if(student.isPresent()) {
			repo.delete(student.get());		
			}
		else {
			throw new StudentResource("Searching id not available");
		}
		return "id deleted ";
	}

}
