package com.demo.crud.service;

import com.demo.crud.dto.EnrollmentDTO;

public interface EnrollmentService 
{
    EnrollmentDTO enrollStudentSubject(String studentId, String subjectId);
}
