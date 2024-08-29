package com.qwerpark.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qwerpark.spring.ex.jpa.domain.Student;
import com.qwerpark.spring.ex.jpa.repository.StudentRepository;
import com.qwerpark.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// 임시로 사용하는 형
	@Autowired
	private StudentRepository studentRepository;
	
	
	// C, U, D
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		// 박상훈, 010-4810-9210, bp4sp4@naver.com, 개발자
		
		Student student = studentService.addStudent("박상훈", "010-4qwer-9210", "bp4sp4@naver.com", "개발");
		return student;
	}
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 3인 학생정보의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(4, "강사");
		return student;
	}
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		// id가 4인 학생정보 삭제
		studentService.deleteStudent(4);
		return "삭제!";
	}
	
	@GetMapping("/find")
	@ResponseBody
	public List<Student>  findStudent() {
		
		// 모든행 조회
		List<Student> studentList =null;
//				studentList = studentRepository.findAll();
//		studentList = studentRepository.findAllByOrderByIdDesc();
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
//		studentList = studentRepository.findByName("박상훈");

		
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
//		studentList = studentRepository.findByNameIn(nameList);
//		studentList = studentRepository.findByEmailContaining("naver");
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 3);
		studentList = studentRepository.selectByDreamJob("프로그래머");
		
		return studentList;
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
