package com.cadence.studentList.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	@GetMapping
	public List<Student> getAllStudent() {
		
		List<Student> students = Arrays.asList(
				new Student (
						1L,
						"Test1 name",
						"test1@gmail.com",
						Gender.MALE	),			
				new Student (
						2L,
						"Test2 name",
						"test2@gmail.com",
						Gender.FEMALE	),
				new Student (
						3L,
						"Test3 name",
						"test3@gmail.com",
						Gender.FEMALE	)
				);
		return students;
	}

}
