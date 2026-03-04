package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Designation;

@Repository("desigrepo")
public interface DesignationRepository extends JpaRepository<Designation, Long> {

	@Query("UPDATE Designation d SET d.designation=:desig WHERE d.designationId=:id")
	@Modifying
	public int updateDesignation(Long id, String desig);
}
