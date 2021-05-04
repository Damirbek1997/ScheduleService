package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.repositories.SubjectRepository;
import com.example.scheduleservice.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultSubjectService implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public DefaultSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAllByIsDeleted(false);
    }

    @Override
    public List<Subject> findAllByDepartmentId(Long departmentId) {
        return subjectRepository.findAllByDepartmentIdAndIsDeleted(departmentId, false);
    }

    @Override
    public List<Subject> findAllByTeacherId(Long teacherId) {
        return subjectRepository.findAllByTeacherIdAndIsDeleted(teacherId, false);
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findByIdAndIsDeleted(id, false).orElseThrow(() -> new EntityNotFoundException("Subject with " + id + "not found!"));
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}