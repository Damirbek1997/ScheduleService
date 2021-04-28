package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Faculty;
import com.example.scheduleservice.repositories.FacultyRepository;
import com.example.scheduleservice.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultFacultyService implements FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public DefaultFacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Faculty with " + id + " not found!"));
    }

    @Override
    public Faculty changeById(Long id, Faculty newFaculty) throws Exception {
        return facultyRepository.findById(id).
                map(faculty -> {
                    faculty.setFaculty(newFaculty.getFaculty());

                    return facultyRepository.save(faculty);
                }).orElseThrow(Exception :: new);
    }
}
