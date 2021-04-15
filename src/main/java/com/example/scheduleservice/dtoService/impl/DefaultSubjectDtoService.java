package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.crud.CreateSubjectDto;
import com.example.scheduleservice.dto.crud.UpdateSubjectDto;
import com.example.scheduleservice.dtoService.SubjectDtoService;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.services.SubjectService;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSubjectDtoService implements SubjectDtoService {
    private final SubjectMapper subjectMapper;
    private final SubjectService subjectService;
    private final UserService userService;

    @Autowired
    public DefaultSubjectDtoService(SubjectService subjectService, SubjectMapper subjectMapper, UserService userService) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
        this.userService = userService;
    }

    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        Subject subject = new Subject();

        // converting to entity
        subject.setTeacher(userService.findById(createSubjectDto.getTeacherId()));
        subject.setSubject(createSubjectDto.getSubject());

        return subjectMapper.toSubjectDto(subjectService.save(subject));
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
        Subject subject = new Subject();

        // converting to entity
        subject.setTeacher(userService.findById(updateSubjectDto.getTeacherId()));
        subject.setSubject(updateSubjectDto.getSubject());

        return subjectMapper.toSubjectDto(subjectService.changeById(id, subject));
    }
}