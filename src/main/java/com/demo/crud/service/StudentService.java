package com.demo.crud.service;

import java.util.List;

import com.demo.crud.dto.StudentDTO;

public interface StudentService 
{
    StudentDTO create(StudentDTO dto);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(String studentId);

    StudentDTO updateStudentById(String studentId, StudentDTO dto);

    boolean deleteStudent(String studentId);
}
