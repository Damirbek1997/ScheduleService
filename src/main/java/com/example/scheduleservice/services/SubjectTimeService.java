package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.SubjectTime;

import java.util.List;

public interface SubjectTimeService {
    List<SubjectTime> findAll();
    SubjectTime findById(Long id);
}
