package com.demo.crud.service.impl;

import com.demo.crud.dto.StudentDTO;
import com.demo.crud.model.Student;
import com.demo.crud.repository.StudentRepository;
import com.demo.crud.service.StudentService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService 
{
    @Autowired
    StudentRepository repo;

    @Override
    public StudentDTO create(StudentDTO dto) 
    {
        Optional<Student> existingStudent = repo.findById(dto.getId());
    
        if (existingStudent.isPresent()) 
        {
            throw new RuntimeException("Student with ID " + dto.getId() + " already exists.");
        }
        else
        {
            Student savedEntity = toEntity(dto);
            Student saveStudent = repo.save(savedEntity);
            StudentDTO savedDto = toDto(saveStudent);
            return savedDto;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = repo.findAll();

        if (students.isEmpty()) {
            throw new RuntimeException("Student Records Not Found.");
        }
        else
        {
            List<StudentDTO> dtos = new ArrayList<>();
            for (Student entity : students) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }

    @Override
    public StudentDTO getStudentById(String studentId) 
    {
        Optional<Student> student = repo.findById(studentId);

        if (!student.isPresent()) {
            throw new RuntimeException("Student with ID " + studentId + " not found.");
        }
        else
        {
            return toDto(student.get());
        }
    }

    @Override
    public StudentDTO updateStudentById(String studentId, StudentDTO dto) 
    {
        Optional<Student> student = repo.findById(studentId);

        if (!student.isPresent()) {
            throw new RuntimeException("Student with ID " + studentId + " not found.");
        }
        else
        {
            Student savedEntity = toEntity(dto);
            Student saveStudent = repo.save(savedEntity);
            StudentDTO savedDto = toDto(saveStudent);
            return savedDto;
        }
    }

    @Override
    public boolean deleteStudent(String studentId) 
    {
        Optional<Student> student = repo.findById(studentId);

        if (!student.isPresent()) {
            throw new RuntimeException("Student with ID " + studentId + " not found.");
        }
        else
        {
            repo.deleteById(studentId);
            return true;
        }
    }

    private Student toEntity(StudentDTO dto)
    {
        Student entity = new Student();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());

        return entity;
    }

    private StudentDTO toDto(Student entity)
    {
        StudentDTO dto = new StudentDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());

        return dto;
    }
}
