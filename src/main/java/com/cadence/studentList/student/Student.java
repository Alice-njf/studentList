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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	@NotBlank
	@Column(nullable=false)
	private String name;
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Gender gender;
	
	public Student(String name, String email, Gender gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	

}
