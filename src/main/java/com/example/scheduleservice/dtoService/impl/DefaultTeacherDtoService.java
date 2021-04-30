package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dto.crud.CreateTeacherDto;
import com.example.scheduleservice.dto.crud.UpdateTeacherDto;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.mapper.UserMapper;
import com.example.scheduleservice.services.TeacherService;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherDtoService implements TeacherDtoService {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    private final SubjectMapper subjectMapper;
    private final UserService userService;

    @Autowired
    public DefaultTeacherDtoService(TeacherService teacherService, TeacherMapper teacherMapper, SubjectMapper subjectMapper, UserService userService) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
        this.subjectMapper = subjectMapper;
        this.userService = userService;
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teacherList = teacherService.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();

        teacherList.forEach(teacher -> {
            TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);

            teacherDtos.add(teacherDto);
        });

        return teacherDtos;
    }

    @Override
    public TeacherDto findById(Long id) {
        return teacherMapper.toTeacherDto(teacherService.findById(id));
    }

    @Override
    public TeacherDto save(CreateTeacherDto createTeacherDto) {
        Teacher teacher = new Teacher();

        teacher.setFirstname(createTeacherDto.getFirstname());
        teacher.setLastname(createTeacherDto.getLastname());

        if (createTeacherDto.getUserId() != null) {
            teacher.setUser(userService.findById(createTeacherDto.getUserId()));
        }

//        if (createTeacherDto.getSubjectDtos() != null) {
//            List<Subject> subjects = new ArrayList<>();
//
//            createTeacherDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));
//
//            teacher.setSubjects(subjects);
//        }

        return teacherMapper.toTeacherDto(teacherService.save(teacher));
    }

    @Override
    public TeacherDto update(Long id, UpdateTeacherDto updateTeacherDto) {
        Teacher teacher = teacherService.findById(id);

        teacher.setFirstname(updateTeacherDto.getFirstname());
        teacher.setLastname(updateTeacherDto.getLastname());

//        if (updateTeacherDto.getSubjectDtos() != null) {
//            List<Subject> subjects = new ArrayList<>();
//
//            updateTeacherDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));
//
//            teacher.setSubjects(subjects);
//        }

        return teacherMapper.toTeacherDto(teacherService.save(teacher));
    }

    @Override
    public void delete(Long id) {
        teacherService.delete(id);
    }
}
