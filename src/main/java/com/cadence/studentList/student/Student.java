package com.cadence.studentList.student;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Student {

	//attributes
	private Long id;
	private String name;
	private String email;
	private Gender gender;	
	
	
}
