package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.crud.CreateSubjectDto;
import com.example.scheduleservice.dto.crud.UpdateSubjectDto;
import com.example.scheduleservice.dtoService.SubjectDtoService;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.services.DepartmentService;
import com.example.scheduleservice.services.SubjectService;
import com.example.scheduleservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultSubjectDtoService implements SubjectDtoService {
    private final SubjectMapper subjectMapper;
    private final SubjectService subjectService;
    private final DepartmentService departmentService;
    private final TeacherService teacherService;

    @Autowired
    public DefaultSubjectDtoService(SubjectService subjectService, SubjectMapper subjectMapper, DepartmentService departmentService, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
        this.departmentService = departmentService;
        this.teacherService = teacherService;
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
    public List<SubjectDto> findAllByTeacherId(Long teacherId) {
        List<Subject> subjectList = subjectService.findAllByTeacherId(teacherId);
        List<SubjectDto> subjectDtoList = new ArrayList<>();

        subjectList.forEach(subject -> {
            SubjectDto subjectDto = subjectMapper.toSubjectDto(subject);

            subjectDtoList.add(subjectDto);
        });

        return subjectDtoList;
    }

    @Override
    public List<SubjectDto> findAllByDepartmentId(Long departmentId) {
        List<Subject> subjectList = subjectService.findAllByDepartmentId(departmentId);
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
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        Subject subject = new Subject();

        if (createSubjectDto.getTeacherId() != null) {
            subject.setTeacher(teacherService.findById(createSubjectDto.getTeacherId()));
        }

        if (createSubjectDto.getDepartmentId() != null) {
            subject.setDepartment(departmentService.findById(createSubjectDto.getDepartmentId()));
        }

        subject.setSubject(createSubjectDto.getSubject());

        return subjectMapper.toSubjectDto(subjectService.save(subject));
    }

    @Override
    public SubjectDto update(Long id, UpdateSubjectDto updateSubjectDto) {
        Subject subject = subjectService.findById(id);

        subject.setSubject(updateSubjectDto.getSubject());

        if (updateSubjectDto.getTeacherId() != null) {
            subject.setTeacher(teacherService.findById(updateSubjectDto.getTeacherId()));
        }

        if (updateSubjectDto.getDepartmentId() != null) {
            subject.setDepartment(departmentService.findById(updateSubjectDto.getDepartmentId()));
        }

        return subjectMapper.toSubjectDto(subjectService.save(subject));
    }

    @Override
    public void delete(Long id) {
        Subject subject = subjectService.findById(id);

        subject.setIsDeleted(true);

        subjectService.save(subject);
    }
}