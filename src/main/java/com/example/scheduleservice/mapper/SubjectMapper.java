package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    @Mappings({
            @Mapping(source = "department", target = "departmentDto"),
            @Mapping(source = "teacher", target = "teacherDto")
    })
    SubjectDto toSubjectDto(Subject subject);

    @InheritInverseConfiguration
    Subject toSubject(SubjectDto subjectDto);
}
