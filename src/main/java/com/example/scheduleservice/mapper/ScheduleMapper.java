package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.entities.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    @Mappings({
            @Mapping(source = "subject.id", target = "subjectId"),
            @Mapping(source = "subject.subject", target = "subject"),
            @Mapping(source = "subject.teacher.id", target = "teacherId"),
            @Mapping(source = "subject.teacher.firstname", target = "firstname"),
            @Mapping(source = "subject.teacher.lastname", target = "lastname"),
            @Mapping(source = "group.id", target = "groupId"),
            @Mapping(source = "group.groupName", target = "group"),
            @Mapping(source = "group.department.id", target = "departmentId"),
            @Mapping(source = "group.department.department", target = "department"),
            @Mapping(source = "group.department.faculty.id", target = "facultyId"),
            @Mapping(source = "group.department.faculty.faculty", target = "faculty"),
            @Mapping(source = "cabinet.id", target = "cabinetId"),
            @Mapping(source = "cabinet.cabinet", target = "cabinet"),
            @Mapping(source = "cabinet.subjectTime.id", target = "subjectTimeId"),
            @Mapping(source = "cabinet.subjectTime.time", target = "time")
    })
    ScheduleDto toScheduleDto(Schedule schedule);
}
