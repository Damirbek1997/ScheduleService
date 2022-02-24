package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mappings({
            @Mapping(source = "user.role.id", target = "userDto.roleId"),
            @Mapping(source = "user.role.role", target = "userDto.role"),
            @Mapping(source = "user.teacher.id", target = "userDto.teacherId"),
            @Mapping(source = "user.teacher.firstname", target = "userDto.firstname"),
            @Mapping(source = "user.teacher.lastname", target = "userDto.lastname"),
            @Mapping(source = "subjects", target = "subjectDtos")
    })
    TeacherDto toTeacherDto(Teacher teacher);

    @InheritInverseConfiguration
    Teacher toTeacher(TeacherDto teacherDto);
}
