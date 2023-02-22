package com.cadence.studentList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class StudentListApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

}
