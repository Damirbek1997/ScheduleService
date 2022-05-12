package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.dtoService.SubjectTimeDtoService;
import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.mapper.SubjectTimeMapper;
import com.example.scheduleservice.services.SubjectTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultSubjectTImeDtoService implements SubjectTimeDtoService {
    private final SubjectTimeService subjectTimeService;

    @Autowired
    public DefaultSubjectTImeDtoService(SubjectTimeService subjectTimeService) {
        this.subjectTimeService = subjectTimeService;
    }

    @Override
    public List<SubjectTimeDto> findAll() {
        List<SubjectTime> subjectTimes = subjectTimeService.findAll();
        List<SubjectTimeDto> subjectTimeDtos = new ArrayList<>();

        subjectTimes.forEach(subjectTime -> {
            SubjectTimeDto subjectTimeDto = SubjectTimeMapper.INSTANCE.toSubjectTime(subjectTime);

            subjectTimeDtos.add(subjectTimeDto);
        });

        return subjectTimeDtos;
    }

    @Override
    public SubjectTimeDto findById(Long id) {
        return SubjectTimeMapper.INSTANCE.toSubjectTime(subjectTimeService.findById(id));
    }
}
