package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.entities.SubjectTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectTimeMapper {
    SubjectTimeMapper INSTANCE = Mappers.getMapper(SubjectTimeMapper.class);

    SubjectTimeDto toSubjectTime(SubjectTime subjectTime);
}
