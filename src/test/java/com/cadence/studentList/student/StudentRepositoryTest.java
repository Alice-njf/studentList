package com.cadence.studentList.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	
	@Test
	void testSelectEmailExists() {
		//given
		Student student = new Student(
				"Jhon lee", "lee@gmail.com", Gender.MALE);
		underTest.save(student);
		
		//when
		boolean exists = underTest.selectExistsEmail(student.getEmail());
		//then
		assertThat(exists).isTrue();
	}
	
	@Test
	void testSelectEmailNotExists() {
		//given
		String email = "lee@gmail.com";
		
		//when
		boolean exists = underTest.selectExistsEmail(email);
		//then
		assertThat(exists).isTrue();
	}
}
