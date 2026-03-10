package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
import java.util.List;
import com.example.demo.entity.Class;

@Repository("studrepo")
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("UPDATE Student s SET s.studentId=:stud_id,s.studentFirstName=:fname,s.studentMiddleName=:mname, s.studentLastName=:lname,"
			+ "s.contactNumber=:contact,s.studentAddress=:address, s.registrationNumber=:reg_number,s.aadharNumber=:aadhar WHERE s.studentId=:stud_id ")
	@Modifying
	public int updateStudent(Long stud_id, String fname, String mname, String lname, Long contact, Long aadhar,
			String reg_number, String address);

	Optional<Student> findByAadharNumber(Long aadharNumber);
	
	Optional<Student> findByAadharNumberOrRegistrationNumber(Long aadharNumber, String registrationNumber);

	Optional<Student> findByAadharNumberAndStudentId(Long aadharNumber, Long studentId);

	Optional<Student> findByRegistrationNumber(String registrationNumber);

	List<Student> findByClassObj(Class classObj);

}
