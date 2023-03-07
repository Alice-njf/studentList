package com.cadence.studentList.student;


import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table  
@Data
public class Student {
	//attributes
	@Id
	@SequenceGenerator(name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			generator = "student_sequence",
			strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "email", nullable = false)
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public Student(String name, String email, Gender gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	

}
