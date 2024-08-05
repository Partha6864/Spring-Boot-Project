package com.demo.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.crud.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> 
{
    @Query(value = "SELECT * FROM student_subject WHERE student_id = :X AND subject_id = :Y",nativeQuery = true)
    Optional<Enrollment> findExistingEnrolled(@Param("X") String studentId,@Param("Y") String subjectId);
}
