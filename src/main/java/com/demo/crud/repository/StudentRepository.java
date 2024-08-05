package com.demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> 
{
    @Query(value = "SELECT student_name FROM student Where student_Id = :X",nativeQuery = true)
    String getStudentName(@Param("X") String studentId);
}