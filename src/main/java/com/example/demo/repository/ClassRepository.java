package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("classrepo")
public interface ClassRepository extends JpaRepository<com.example.demo.entity.Class, Long> {

	@Query("UPDATE Class c set c.className=:className WHERE c.classId=id")
	@Modifying	
	public int updateClass(Long id, String className);
}
