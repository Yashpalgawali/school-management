package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Division;

@Repository("divisionrepo")
public interface DivisionRepository extends JpaRepository<Division, Long> {

	@Query("UPDATE Division d SET d.division=:division,d.classObj.classId=:classId WHERE d.divisionId=:id")
	@Modifying
	public int updateDivision(Long id, String division, Long classId);
}
