package com.cadence.studentList.student;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
@EnableTransactionManagement
@AllArgsConstructor
public class StudentController {
	private final StudentService studentService;

	@GetMapping
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
		/*System.out.println("test ist da");
		List<Student> students = Arrays.asList(
				new Student (
						1L,
						"Test1 name",
						"test1@gmail.com",
						Gender.MALE	),			
				new Student (
						2L,
						"Test5 name",
						"test2@gmail.com",
						Gender.FEMALE	),
				new Student (
						3L,
						"Test3 name",
						"test3@gmail.com",
						Gender.FEMALE	)
				);
		return students;*/
	}
	
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
}
