package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.SubjectTimeDto;

import java.util.List;

public interface SubjectTimeDtoService {
    List<SubjectTimeDto> findAll();
    SubjectTimeDto findById(Long id);
}
