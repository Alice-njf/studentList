package com.cadence.studentList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class StudentListApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

}
