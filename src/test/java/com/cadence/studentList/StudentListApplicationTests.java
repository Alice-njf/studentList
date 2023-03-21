package com.cadence.studentList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class StudentListApplicationTests {

	Calculator addTowNumber = new Calculator();
	@Test
	void itSouldAddNumbers() {
		//given
		int a = 20;
		int b = 30;
		int expectedResult = 50;
		
		//when
		int result = addTowNumber.add(a, b);
		
		//then (from assertj)
		assertThat(result).isEqualTo(expectedResult);
	}
	
	class Calculator {
		int add(int a, int b){
		return a+b;
		};
	}

}
