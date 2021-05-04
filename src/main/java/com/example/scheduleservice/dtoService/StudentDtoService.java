package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.dto.crud.CreateStudentDto;
import com.example.scheduleservice.dto.crud.UpdateStudentDto;

import java.util.List;

public interface StudentDtoService {
    List<StudentDto> findAllByGroupId(Long groupId);
    List<StudentDto> findAll();
    StudentDto findById(Long id);
    StudentDto save(CreateStudentDto createStudentDto);
    StudentDto update(Long id, UpdateStudentDto updateStudentDto);
}
