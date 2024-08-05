package com.demo.crud.controller;

import com.demo.crud.dto.SubjectDTO;
import com.demo.crud.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@RequestBody SubjectDTO dto) 
    {
        try {
            SubjectDTO createSubject = subjectService.create(dto);

            Object response = new Object() {
                public final String message = "Subject Added Successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final SubjectDTO data = createSubject;
            };
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Add Subject";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSubjects() 
    {
        try {
            List<SubjectDTO> subjects = subjectService.getAllSubjects();

            Object response = new Object() {
                public final String message = "All Subjects Details Retrieved Successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final List<SubjectDTO> data = subjects;
            };
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Retrieved All Subjects Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getById/{subjectId}")
    public ResponseEntity<?> getSubjectById(@PathVariable String subjectId) 
    {
        try {
            SubjectDTO subject = subjectService.getSubjectById(subjectId);

            Object response = null;
            if (subject != null) {
                response = new Object() {
                    public final String message = "Subject Details Retrieved Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final SubjectDTO data = subject;
                };
            }
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Retrieved Subject Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/updateById/{subjectId}")
    public ResponseEntity<?> updateSubject(@PathVariable String subjectId, @RequestBody SubjectDTO dto) 
    {
        try {
            SubjectDTO subject = subjectService.updateSubject(subjectId, dto);

            Object response = null;
            if (subject != null) {
                response = new Object() {
                    public final String message = "Subject Details Updated Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final SubjectDTO data = subject;
                };
            }
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Update Subject Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/deleteById/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable String subjectId) 
    {
        try {
            boolean delete = subjectService.deleteSubject(subjectId);
            
            Object response = null;
            if (delete == true) {
                response = new Object() {
                    public final String message = "Subject Details Deleted Successfully";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                };
            }
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to Delete Subject Details";
                public final String statusMessage = "FAILURE";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final String error = e.getMessage();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}