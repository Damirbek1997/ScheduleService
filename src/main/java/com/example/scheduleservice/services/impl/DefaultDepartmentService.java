package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Department;
import com.example.scheduleservice.repositories.DepartmentRepository;
import com.example.scheduleservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultDepartmentService implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DefaultDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department with " + id + " not found!"));
    }

    @Override
    public List<Department> findByFacultyId(Long facultyId) {
        return departmentRepository.retrieveDepartmentsByFacultyId(facultyId);
    }

    @Override
    public Department changeById(Long id, Department newGroup) throws Exception {
        return departmentRepository.findById(id).
                map(department -> {
                    department.setDepartment(newGroup.getDepartment());
                    department.setFaculty(newGroup.getFaculty());

                    return departmentRepository.save(department);
                }).orElseThrow(Exception :: new);
    }
}
