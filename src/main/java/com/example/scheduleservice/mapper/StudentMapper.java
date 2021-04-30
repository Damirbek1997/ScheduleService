package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.entities.Student;

public interface StudentMapper {
    StudentDto toStudentDto(Student student);
    Student toStudent(StudentDto studentDto);
}
