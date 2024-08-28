package com.qwerpark.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qwerpark.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	// 1행 Insert
}
