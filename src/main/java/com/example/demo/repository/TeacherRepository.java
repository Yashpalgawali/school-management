package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Teacher;

@Repository("teacherrepo")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("UPDATE Teacher t SET t.teacherName=:name, t.staffCategory.staffCategoryId=:staffCatId, t.classObj.classId=:classId WHERE t.teacherId=:id ")
	@Modifying
	public int updateTeacher(Long id, String name, Long classId,Long staffCatId);
	
}
