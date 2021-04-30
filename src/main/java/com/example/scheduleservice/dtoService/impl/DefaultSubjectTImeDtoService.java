package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.dtoService.SubjectTimeDtoService;
import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.mapper.SubjectTimeMapper;
import com.example.scheduleservice.services.SubjectTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultSubjectTImeDtoService implements SubjectTimeDtoService {
    private final SubjectTimeService subjectTimeService;
    private final SubjectTimeMapper subjectTimeMapper;

    @Autowired
    public DefaultSubjectTImeDtoService(SubjectTimeService subjectTimeService, SubjectTimeMapper subjectTimeMapper) {
        this.subjectTimeService = subjectTimeService;
        this.subjectTimeMapper = subjectTimeMapper;
    }

    @Override
    public List<SubjectTimeDto> findAll() {
        List<SubjectTime> subjectTimes = subjectTimeService.findAll();
        List<SubjectTimeDto> subjectTimeDtos = new ArrayList<>();

        subjectTimes.forEach(subjectTime -> {
            SubjectTimeDto subjectTimeDto = subjectTimeMapper.toSubjectTime(subjectTime);

            subjectTimeDtos.add(subjectTimeDto);
        });

        return subjectTimeDtos;
    }

    @Override
    public SubjectTimeDto findById(Long id) {
        return subjectTimeMapper.toSubjectTime(subjectTimeService.findById(id));
    }
}
