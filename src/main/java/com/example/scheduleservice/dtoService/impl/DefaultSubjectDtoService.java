package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.crud.CreateSubjectDto;
import com.example.scheduleservice.dto.crud.UpdateSubjectDto;
import com.example.scheduleservice.dtoService.SubjectDtoService;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSubjectDtoService implements SubjectDtoService {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Autowired
    public DefaultSubjectDtoService(SubjectService subjectService, SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        Subject createSubject = new Subject();

        // converting to entity
        createSubject.setSubjectName(createSubject.getSubjectName());

        return subjectMapper.toSubjectDto(subjectService.save(createSubject));
    }

    @Override
    public void deleteById(Long id) {
        subjectService.deleteById(id);
    }

    @Override
    public List<SubjectDto> findAll() {
        List<Subject> subjectList = subjectService.findAll();
        List<SubjectDto> subjectDtoList = new ArrayList<>();

        subjectList.forEach(subject -> {
            SubjectDto subjectDto = subjectMapper.toSubjectDto(subject);

            subjectDtoList.add(subjectDto);
        });

        return subjectDtoList;
    }

    @Override
    public SubjectDto findById(Long id) {
        return subjectMapper.toSubjectDto(subjectService.findById(id));
    }

    @Override
    public SubjectDto changeById(Long id, UpdateSubjectDto updateSubjectDto) throws Exception {
        Subject updateSubject = new Subject();

        // converting to entity
        updateSubject.setSubjectName(updateSubjectDto.getSubjectName());

        return subjectMapper.toSubjectDto(subjectService.changeById(id, updateSubject));
    }
}