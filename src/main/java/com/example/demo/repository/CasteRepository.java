package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Caste;

@Repository("casterepo")
public interface CasteRepository extends JpaRepository<Caste, Long> {

	@Query("UPDATE Caste c SET c.caste=:caste , c.casteCategory.casteCategoryId=:caste_category_id WHERE c.casteId=:id")
	@Modifying
	public int updateCaste(Long id,String caste,Long caste_category_id);
}
