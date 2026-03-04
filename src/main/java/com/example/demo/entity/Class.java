package com.example.demo.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_class")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Class {

	@Id
	@SequenceGenerator(name="class_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "class_seq",strategy = GenerationType.SEQUENCE)
	Long classId;
	
	@NotBlank(message = "Class Name can't be blank")
	String className;
}
