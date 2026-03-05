package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StaffCategory;

@Repository("staffcategoryrepo")
public interface StaffCategoryRepository extends JpaRepository<StaffCategory, Long> {

	@Query("UPDATE StaffCategory s SET s.staffCategory=:category WHERE s.staffCategoryId=:id")
	@Modifying
	public int updateStaffCategory(Long id,String category);
}
