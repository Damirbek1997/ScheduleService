package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "role.id", target = "roleId"),
            @Mapping(source = "role.role", target = "role"),
            @Mapping(source = "teacher.id", target = "teacherId"),
            @Mapping(source = "teacher.firstname", target = "firstname"),
            @Mapping(source = "teacher.lastname", target = "lastname"),
            @Mapping(source = "student.group.id", target = "groupId"),
            @Mapping(source = "student.group.groupName", target = "group"),
            @Mapping(source = "student.group.department.id", target = "departmentId"),
            @Mapping(source = "student.group.department.department", target = "department"),
            @Mapping(source = "student.group.department.faculty.id", target = "facultyId"),
            @Mapping(source = "student.group.department.faculty.faculty", target = "faculty"),
    })
    UserDto toUserDto(User user);
}
