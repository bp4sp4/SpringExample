package com.qwerpark.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qwerpark.spring.ex.jpa.domain.Student;
import com.qwerpark.spring.ex.jpa.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	// C, U, D
	@GetMapping("/jpa/student/create")
	@ResponseBody
	public Student createStudent() {
		// 박상훈, 010-4810-9210, bp4sp4@naver.com, 개발자
		
		Student student = studentService.addStudent("박상훈", "010-4qwer-9210", "bp4sp4@naver.com", "개발");
		return student;
	}
	
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student(10, "박상훈", "010-4710-9210","bp4sp4@naver.com", "프로그래머", null, null);
//		student.setPhoneNumber("010-qwer-9210");
		Student student = Student.builder()
				.name("박상훈")
				.phoneNumber("010-4042-9210")
				.email("bp4sp4@navercom")
				.build();
		return student;
	}
}
