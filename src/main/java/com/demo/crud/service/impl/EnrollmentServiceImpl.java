package com.demo.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.dto.EnrollmentDTO;
import com.demo.crud.model.Enrollment;
import com.demo.crud.model.Student;
import com.demo.crud.model.Subject;
import com.demo.crud.repository.EnrollmentRepository;
import com.demo.crud.repository.StudentRepository;
import com.demo.crud.repository.SubjectRepository;
import com.demo.crud.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService 
{
    @Autowired
    StudentRepository studentRepo;

    @Autowired
    SubjectRepository subjectRepo;

    @Autowired
    EnrollmentRepository enrollRepo;

    @Override
    public EnrollmentDTO enrollStudentSubject(String studentId, String subjectId) 
    {
        Optional<Student> student = studentRepo.findById(studentId);
        Optional<Subject> subject = subjectRepo.findById(subjectId);

        if (student.isPresent() && subject.isPresent()) {
            Optional<Enrollment> existingEnrollment = enrollRepo.findExistingEnrolled(studentId,subjectId);

            if (existingEnrollment.isPresent()) {
                throw new RuntimeException("Student ID: " + studentId + " already enrolled with Subject ID: " + subjectId + ".");
            }
            else
            {
                Enrollment savedEntity = toEntity(studentId,subjectId);
                Enrollment enroll = enrollRepo.save(savedEntity);
                EnrollmentDTO savedDto = toDto(enroll);
                return savedDto;
            }
        }
        else
        {
            throw new RuntimeException("Either Student ID: " + studentId + " or Subject ID: " + subjectId + " doesn't exist.");
        }
    }
    
    private Enrollment toEntity(String studentId,String subjectId)
    {
        Enrollment entity = new Enrollment();

        entity.setStudent_id(studentId);
        entity.setStudent_name(studentRepo.getStudentName(studentId));
        entity.setSubject_id(subjectId);
        entity.setSubject_name(subjectRepo.getSubjectName(subjectId));

        return entity;
    }

    private EnrollmentDTO toDto(Enrollment entity)
    {
        EnrollmentDTO dto = new EnrollmentDTO();

        dto.setStudent_id(entity.getStudent_id());
        dto.setStudent_name(entity.getStudent_name());
        dto.setSubject_id(entity.getSubject_id());
        dto.setSubject_name(entity.getSubject_name());

        return dto;
    }
}
