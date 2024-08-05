package com.demo.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO 
{
    private String student_id;

    private String subject_id;

    private String student_name;

    private String subject_name;
}
