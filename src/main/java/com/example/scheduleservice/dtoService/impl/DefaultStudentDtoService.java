package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.dto.crud.CreateStudentDto;
import com.example.scheduleservice.dto.crud.UpdateStudentDto;
import com.example.scheduleservice.dtoService.StudentDtoService;
import com.example.scheduleservice.entities.Student;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.StudentMapper;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.services.GroupService;
import com.example.scheduleservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultStudentDtoService implements StudentDtoService {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;
    private final GroupService groupService;

    @Autowired
    public DefaultStudentDtoService(StudentService studentService, StudentMapper studentMapper, SubjectMapper subjectMapper, GroupService groupService) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
        this.groupService = groupService;
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentService.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        students.forEach(student -> {
            StudentDto studentDto = studentMapper.toStudentDto(student);

            studentDtos.add(studentDto);
        });

        return studentDtos;
    }

    @Override
    public List<StudentDto> findAllByGroupId(Long groupId) {
        List<Student> students = studentService.findAllByGroupId(groupId);
        List<StudentDto> studentDtos = new ArrayList<>();

        students.forEach(student -> {
            StudentDto studentDto = studentMapper.toStudentDto(student);

            studentDtos.add(studentDto);
        });

        return studentDtos;
    }

    @Override
    public StudentDto findById(Long id) {
        return studentMapper.toStudentDto(studentService.findById(id));
    }

    @Override
    public StudentDto save(CreateStudentDto createStudentDto) { 
        Student student = new Student();

        student.setFirstname(createStudentDto.getFirstname());
        student.setLastname(createStudentDto.getLastname());

        if (createStudentDto.getGroupId() != null) {
            student.setGroup(groupService.findById(createStudentDto.getGroupId()));
        }

        if (createStudentDto.getSubjectDtos() != null) {
            List<Subject> subjects = new ArrayList<>();

            createStudentDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            student.setSubjects(subjects);
        }

        return studentMapper.toStudentDto(studentService.save(student));
    }

    @Override
    public StudentDto update(UpdateStudentDto updateStudentDto) {
        Student student = studentService.findById(updateStudentDto.getStudentId());

        student.setFirstname(updateStudentDto.getFirstname());
        student.setLastname(updateStudentDto.getLastname());

        if (updateStudentDto.getGroupId() != null) {
            student.setGroup(groupService.findById(updateStudentDto.getGroupId()));
        }

        if (updateStudentDto.getSubjectDtos() != null) {
            List<Subject> subjects = new ArrayList<>();

            updateStudentDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            student.setSubjects(subjects);
        }

        return studentMapper.toStudentDto(studentService.save(student));
    }
}
