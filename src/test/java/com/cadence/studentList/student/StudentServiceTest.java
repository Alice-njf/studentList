package com.cadence.studentList.student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class StudentServiceTest {
	
	private StudentService underTest;
	@Mock
	private StudentRepository studentRepository;
	private AutoCloseable autocloseable;
	
	@BeforeEach
	void setUp() {
		//To initiate StudentRepository mock
		autocloseable = MockitoAnnotations.openMocks(this);
		underTest = new StudentService(studentRepository);		
	}
	@AfterEach
	void tearDown() throws Exception {
		autocloseable.close();
	}
	@Test
	void canGetAllStudent() {
		//when
		underTest.getAllStudent();
		//then verify studentRepository was invoked by findAll()
		verify(studentRepository).findAll();
	}

	@Test
	@Disabled
	void testAddStudent() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteStudent() {
		fail("Not yet implemented");
	}

}
