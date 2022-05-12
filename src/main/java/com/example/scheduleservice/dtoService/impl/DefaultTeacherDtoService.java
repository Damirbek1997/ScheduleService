package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dto.crud.CreateTeacherDto;
import com.example.scheduleservice.dto.crud.UpdateTeacherDto;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultTeacherDtoService implements TeacherDtoService {
    private final TeacherService teacherService;

    @Autowired
    public DefaultTeacherDtoService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teacherList = teacherService.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();

        teacherList.forEach(teacher -> {
            TeacherDto teacherDto = TeacherMapper.INSTANCE.toTeacherDto(teacher);

            teacherDtos.add(teacherDto);
        });

        return teacherDtos;
    }

    @Override
    public TeacherDto findById(Long id) {
        return TeacherMapper.INSTANCE.toTeacherDto(teacherService.findById(id));
    }

    @Override
    public TeacherDto save(CreateTeacherDto createTeacherDto) {
        Teacher teacher = new Teacher();

        teacher.setFirstname(createTeacherDto.getFirstname());
        teacher.setLastname(createTeacherDto.getLastname());
        teacher.setIsDeleted(false);

        return TeacherMapper.INSTANCE.toTeacherDto(teacherService.save(teacher));
    }

    @Override
    public TeacherDto update(UpdateTeacherDto updateTeacherDto) {
        Teacher teacher = teacherService.findById(updateTeacherDto.getTeacherId());

        teacher.setFirstname(updateTeacherDto.getFirstname());
        teacher.setLastname(updateTeacherDto.getLastname());

        return TeacherMapper.INSTANCE.toTeacherDto(teacherService.save(teacher));
    }
}
