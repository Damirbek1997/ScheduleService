package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.entities.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(source = "user.role.id", target = "userDto.roleId"),
            @Mapping(source = "user.role.role", target = "userDto.role"),
            @Mapping(source = "user.teacher.id", target = "userDto.teacherId"),
            @Mapping(source = "user.teacher.firstname", target = "userDto.firstname"),
            @Mapping(source = "user.teacher.lastname", target = "userDto.lastname"),
            @Mapping(source = "group", target = "groupDto"),
            @Mapping(source = "group.department.id", target = "userDto.departmentId"),
            @Mapping(source = "group.department.department", target = "userDto.department"),
            @Mapping(source = "group.department.faculty.id", target = "userDto.facultyId"),
            @Mapping(source = "group.department.faculty.faculty", target = "userDto.faculty"),
            @Mapping(source = "subjects", target = "subjectDtos")
    })
    StudentDto toStudentDto(Student student);

    @InheritInverseConfiguration
    Student toStudent(StudentDto studentDto);
}
