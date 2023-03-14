package com.cadence.studentList.student;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void deleteStudent(Long StudentId) {
		studentRepository.deleteById(StudentId);
		
	}
	
}
