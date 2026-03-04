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
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_division")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class Division {

	@Id
	@SequenceGenerator(name="division_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "division_seq",strategy = GenerationType.SEQUENCE)
	Long divisionId;
	
	@NotBlank(message = "Division can't be blank")
	String division;

	@ManyToOne
	@JoinColumn(name = "class_id")
	Class classObj;
}
