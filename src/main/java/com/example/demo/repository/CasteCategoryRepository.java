package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CasteCategory;

@Repository("castecategoryrepo")
public interface CasteCategoryRepository extends JpaRepository<CasteCategory, Long> {

	@Query("UPDATE CasteCategory s SET s.casteCategory=:category WHERE s.casteCategoryId=:id")
	@Modifying
	public int updateCasteCategory(Long id,String category);
}
