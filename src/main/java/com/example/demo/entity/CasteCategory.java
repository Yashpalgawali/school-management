package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="tbl_caste_category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class CasteCategory {

	@Id
	@SequenceGenerator(name="caste_category_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "caste_category_seq",strategy = GenerationType.SEQUENCE)
	Long casteCategoryId;
	
	String casteCategory;
}
