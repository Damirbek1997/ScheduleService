package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Student;
import com.example.scheduleservice.repositories.StudentRepository;
import com.example.scheduleservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultStudentService implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public DefaultStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByIsDeleted(false);
    }

    @Override
    public List<Student> findAllByGroupId(Long groupId) {
        return studentRepository.findAllByGroupIdAndIsDeleted(groupId, false);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findByIdAndIsDeleted(id, false).orElseThrow(() -> new EntityNotFoundException("Student with " + id + " not found!"));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
