package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.repositories.TeacherRepository;
import com.example.scheduleservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultTeacherService implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public DefaultTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Teacher with " + id + " not found!"));
    }

    @Override
    public Teacher changeById(Long id, Teacher newTeacher) throws Exception {
        return teacherRepository.findById(id).
                map(teacher -> {
                    teacher.setUser(newTeacher.getUser());

                    return teacherRepository.save(teacher);
                }).orElseThrow(Exception::new);
    }
}
