package com.example.demo.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name= "tbl_student", 
uniqueConstraints = {
        @UniqueConstraint(columnNames = "aadharNumber"),
        @UniqueConstraint(columnNames = "registrationNumber")
    }	)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Student {

	@Id
	@SequenceGenerator(name="student_seq" ,allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "student_seq",strategy = GenerationType.SEQUENCE)
	Long studentId;
	
	@NotNull(message = "Student First Name can't be null")
	@NotBlank(message = "Student First Name can't be Blank")
	@Size(min = 2,max=50, message = "Student First Name must have at least 2 characters")
	String studentFirstName;	
	
	String studentMiddleName;
	
	@NotNull(message = "Student Last Name can't be null")
	@NotBlank(message = "Student Last Name can't be Blank")
	@Size(min = 2,max=50, message = "Student Last Name must have at least 2 characters")
	String studentLastName;
	
	String studentAddress;
	
	Long aadharNumber;
	
	Long contactNumber;

	String registrationNumber;
	
	String dateOfAdmission;
	
	String dob;
	
	String dateOfLeaving;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	Class classObj;
}
