package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dto.crud.CreateTeacherDto;
import com.example.scheduleservice.dto.crud.UpdateTeacherDto;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherDtoService implements TeacherDtoService {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @Autowired
    public DefaultTeacherDtoService(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDto save(CreateTeacherDto createTeacherDto) {
        Teacher createTeacher = new Teacher();

        // converting to entity
        createTeacher.setFirstname(createTeacher.getFirstname());
        createTeacher.setLastname(createTeacher.getLastname());

        return teacherMapper.toTeacherDto(teacherService.save(createTeacher));
    }

    @Override
    public void deleteById(Long id) {
        teacherService.deleteById(id);
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teacherList = teacherService.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        teacherList.forEach(teacher -> {
            TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);

            teacherDtoList.add(teacherDto);
        });

        return teacherDtoList;
    }

    @Override
    public TeacherDto findById(Long id) {
        return teacherMapper.toTeacherDto(teacherService.findById(id));
    }

    @Override
    public TeacherDto changeById(Long id, UpdateTeacherDto updateTeacherDto) throws Exception {
        Teacher updateTeacher = new Teacher();

        // converting to entity
        updateTeacher.setFirstname(updateTeacherDto.getFirstname());
        updateTeacher.setLastname(updateTeacherDto.getLastname());

        return teacherMapper.toTeacherDto(teacherService.changeById(id, updateTeacher));
    }
}
