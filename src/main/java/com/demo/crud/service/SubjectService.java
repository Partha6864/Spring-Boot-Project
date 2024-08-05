package com.demo.crud.service;

import java.util.List;

import com.demo.crud.dto.SubjectDTO;

public interface SubjectService 
{
    SubjectDTO create(SubjectDTO dto);

    List<SubjectDTO> getAllSubjects();

    SubjectDTO getSubjectById(String subjectId);

    SubjectDTO updateSubject(String subjectId, SubjectDTO dto);

    boolean deleteSubject(String subjectId);
}
