package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.ScheduleTimeDto;
import com.example.scheduleservice.dtoService.SubjectTimeDtoService;
import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.mapper.SubjectTimeMapper;
import com.example.scheduleservice.services.SubjectTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSubjectTImeDtoService implements SubjectTimeDtoService {
    private final SubjectTimeService subjectTimeService;
    private final SubjectTimeMapper subjectTimeMapper;

    @Autowired
    public DefaultSubjectTImeDtoService(SubjectTimeService subjectTimeService, SubjectTimeMapper subjectTimeMapper) {
        this.subjectTimeService = subjectTimeService;
        this.subjectTimeMapper = subjectTimeMapper;
    }

    @Override
    public List<ScheduleTimeDto> findAll() {
        List<SubjectTime> subjectTimes = subjectTimeService.findAll();
        List<ScheduleTimeDto> scheduleTimeDtos = new ArrayList<>();

        subjectTimes.forEach(subjectTime -> {
            ScheduleTimeDto scheduleTimeDto = subjectTimeMapper.toSubjectTime(subjectTime);

            scheduleTimeDtos.add(scheduleTimeDto);
        });

        return scheduleTimeDtos;
    }

    @Override
    public ScheduleTimeDto findById(Long id) {
        return subjectTimeMapper.toSubjectTime(subjectTimeService.findById(id));
    }
}
