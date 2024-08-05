package com.demo.crud.service.impl;

import com.demo.crud.dto.SubjectDTO;
import com.demo.crud.model.Subject;
import com.demo.crud.repository.SubjectRepository;
import com.demo.crud.service.SubjectService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository repo;

    @Override
    public SubjectDTO create(SubjectDTO dto) 
    {
        Optional<Subject> existingSubject = repo.findById(dto.getId());

        if (existingSubject.isPresent()) 
        {
            throw new RuntimeException("Subject with ID " + dto.getId() + " already exists.");
        }
        else
        {
            Subject savedEntity = toEntity(dto);
            Subject saveSubject = repo.save(savedEntity);
            SubjectDTO savedDto = toDto(saveSubject);
            return savedDto;
        }
    }

    @Override
    public List<SubjectDTO> getAllSubjects() 
    {
        List<Subject> subjects = repo.findAll();

        if (subjects.isEmpty()) {
            throw new RuntimeException("Subjects Not Found.");
        }
        else
        {
            List<SubjectDTO> dtos = new ArrayList<>();
            for (Subject entity : subjects) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }

    @Override
    public SubjectDTO getSubjectById(String subjectId) 
    {
        Optional<Subject> subject = repo.findById(subjectId);

        if (!subject.isPresent()) {
            throw new RuntimeException("Subject with ID " + subjectId + " not found.");
        }
        else
        {
            return toDto(subject.get());
        }
    }

    @Override
    public SubjectDTO updateSubject(String subjectId, SubjectDTO dto) {
        Optional<Subject> subject = repo.findById(subjectId);

        if (!subject.isPresent()) {
            throw new RuntimeException("Subject with ID " + subjectId + " not found.");
        }
        else
        {
            Subject savedEntity = toEntity(dto);
            Subject saveSubject = repo.save(savedEntity);
            SubjectDTO savedDto = toDto(saveSubject);
            return savedDto;
        }
    }

    @Override
    public boolean deleteSubject(String subjectId) {
        Optional<Subject> subject = repo.findById(subjectId);

        if (!subject.isPresent()) {
            throw new RuntimeException("Subject with ID " + subjectId + " not found.");
        }
        else
        {
            repo.deleteById(subjectId);
            return true;
        }
    }

    private Subject toEntity(SubjectDTO dto)
    {
        Subject entity = new Subject();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    private SubjectDTO toDto(Subject entity)
    {
        SubjectDTO dto = new SubjectDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}
