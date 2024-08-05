package com.demo.crud.repository;

import com.demo.crud.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> 
{
    @Query(value = "SELECT subject_name FROM subject WHERE subject_id = :X",nativeQuery = true)
    String getSubjectName(@Param("X") String subjectId);
}