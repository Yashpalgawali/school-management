package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="tbl_teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Teacher {

	@Id
	@SequenceGenerator(name="teacher_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "teacher_seq",strategy = GenerationType.SEQUENCE)
	Long teacherId;
	
	String teacherName;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	Class classObj;
	
}
