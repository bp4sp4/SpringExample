package com.qwerpark.spring.ex.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwerpark.spring.ex.jpa.domain.Student;
import com.qwerpark.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob){
		
		Student student = Student.builder()
		.name(name)
		.phoneNumber(phoneNumber)
		.email(email)
		.dereamJob(dreamJob)
		.build();
		
		Student result = studentRepository.save(student);
		return result;
	}
}
