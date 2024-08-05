package com.demo.crud.controller;

import com.demo.crud.dto.StudentDTO;
import com.demo.crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO dto) 
    {
        try {
            StudentDTO createStudent = studentService.create(dto);
            
            Object response = new Object() {
                public final String message = "Student Added Successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final StudentDTO data = createStudent;
            };
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Add Student";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents() 
    {
        try {
            List<StudentDTO> students = studentService.getAllStudents();

            Object response = new Object() {
                public final String message = "All Student Details Retrieved Successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final List<StudentDTO> data = students;
            };
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Retrieved All Student Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getById/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable String studentId) 
    {
        try {
            StudentDTO student = studentService.getStudentById(studentId);

            Object response = null;
            if (student != null) {
                response = new Object() {
                    public final String message = "Student Details Retrieved Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final StudentDTO data = student;
                };
            }
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Retrieved Student Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/updateById/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable String studentId, @RequestBody StudentDTO dto) 
    {
        try {
            StudentDTO student = studentService.updateStudentById(studentId, dto);

            Object response = null;
            if (student != null) {
                response = new Object() {
                    public final String message = "Student Details Updated Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final StudentDTO data = student;
                };
            }
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Update Student Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/deleteById/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentId) 
    {
        try {
            boolean delete = studentService.deleteStudent(studentId);
            
            Object response = null;
            if (delete == true) {
                response = new Object() {
                    public final String message = "Student Details Deleted Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                };
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Delete Student Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}