package com.cadence.studentList.student;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.studentList.student.exception.BadRequestException;
import com.cadence.studentList.student.exception.StudentNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		Boolean existsEmail = studentRepository
				.selectExistsEmail(student.getEmail());
		if (existsEmail) {
			throw new BadRequestException(
					"Email" + student.getEmail() + " taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		if(!studentRepository.existsById(studentId)) {
			throw new StudentNotFoundException(
					"Student by Id: " + studentId + " does not exists");
		}
		studentRepository.deleteById(studentId);
		
	}
	
}
