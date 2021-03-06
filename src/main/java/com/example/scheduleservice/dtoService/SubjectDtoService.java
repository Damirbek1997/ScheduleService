package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.crud.CreateSubjectDto;
import com.example.scheduleservice.dto.crud.UpdateSubjectDto;
import com.example.scheduleservice.entities.Subject;

import java.util.List;

public interface SubjectDtoService {
    List<SubjectDto> findAll();
    List<SubjectDto> findAllByTeacherId(Long teacherId);
    List<SubjectDto> findAllByDepartmentId(Long departmentId);
    SubjectDto findById(Long id);
    SubjectDto save(CreateSubjectDto createSubjectDto);
    SubjectDto update(Long id, UpdateSubjectDto updateSubjectDto);
    void delete(Long id);
}
