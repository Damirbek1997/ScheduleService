package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Student;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.GroupMapper;
import com.example.scheduleservice.mapper.StudentMapper;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultStudentMapper implements StudentMapper {
    private final SubjectMapper subjectMapper;
    private final GroupMapper groupMapper;
    private final UserMapper userMapper;

    @Autowired
    public DefaultStudentMapper(SubjectMapper subjectMapper, GroupMapper groupMapper, UserMapper userMapper) {
        this.subjectMapper = subjectMapper;
        this.groupMapper = groupMapper;
        this.userMapper = userMapper;
    }

    @Override
    public StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());

        if (student.getGroup() != null) {
            studentDto.setGroupDto(groupMapper.toGroupDto(student.getGroup()));
        }

        if (student.getUser() != null) {
            studentDto.setUserDto(userMapper.toUserDto(student.getUser()));
        }

        if (student.getSubjects() != null) {
            List<SubjectDto> subjectDtos = new ArrayList<>();

            student.getSubjects().forEach(subject -> subjectDtos.add(subjectMapper.toSubjectDto(subject)));

            studentDto.setSubjectDtos(subjectDtos);
        }

        return studentDto;
    }

    @Override
    public Student toStudent(StudentDto studentDto) {
        Student student = new Student();

        student.setId(studentDto.getId());
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());

        if (studentDto.getGroupDto() != null) {
            student.setGroup(groupMapper.toGroup(studentDto.getGroupDto()));
        }

        if (studentDto.getUserDto() != null) {
            student.setUser(userMapper.toUser(studentDto.getUserDto()));
        }

        if (studentDto.getSubjectDtos() != null) {
            List<Subject> subjects = new ArrayList<>();

            studentDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            student.setSubjects(subjects);
        }

        return student;
    }
}
