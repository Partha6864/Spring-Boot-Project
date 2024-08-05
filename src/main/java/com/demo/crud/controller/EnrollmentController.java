package com.demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.dto.EnrollmentDTO;
import com.demo.crud.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enrollment")
@RequiredArgsConstructor
public class EnrollmentController 
{
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("/student-subject")
    public ResponseEntity<?> enrollStudentSubject(@RequestParam String studentId,@RequestParam String subjectId)
    {
        try {
            EnrollmentDTO enrolled = enrollmentService.enrollStudentSubject(studentId,subjectId);

             Object response = new Object() {
                public final String message = "Student Enrolled Successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final EnrollmentDTO data = enrolled;
            };
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Enroll Student";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
