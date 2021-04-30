package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.dtoService.StudentDtoService;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import com.example.scheduleservice.dtoService.UserDtoService;
import com.example.scheduleservice.entities.Student;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.exceptions.InappropriatePasswordException;
import com.example.scheduleservice.mapper.StudentMapper;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.mapper.UserMapper;
import com.example.scheduleservice.services.RoleService;
import com.example.scheduleservice.services.StudentService;
import com.example.scheduleservice.services.TeacherService;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class DefaultUserDtoService implements UserDtoService {
    private final UserMapper userMapper;
    private final UserService userService;
    private final RoleService roleService;
    private final TeacherDtoService teacherDtoService;
    private final TeacherMapper teacherMapper;
    private final StudentDtoService studentDtoService;
    private final StudentMapper studentMapper;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public DefaultUserDtoService(UserMapper userMapper, UserService userService, RoleService roleService, TeacherDtoService teacherDtoService, TeacherMapper teacherMapper, StudentDtoService studentDtoService, StudentMapper studentMapper, TeacherService teacherService, StudentService studentService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.roleService = roleService;
        this.teacherDtoService = teacherDtoService;
        this.teacherMapper = teacherMapper;
        this.studentDtoService = studentDtoService;
        this.studentMapper = studentMapper;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDto userDto = userMapper.toUserDto(user);

            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public List<UserDto> findAllByRoleId(Long roleId) {
        List<User> userList = userService.findAllByRoleId(roleId);
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDto userDto = userMapper.toUserDto(user);

            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toUserDto(userService.findById(id));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toUserDto(userService.findByEmail(email));
    }

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        User user = new User();

        // converting to entity
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());

        if (createUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(createUserDto.getRoleId()));
        }

        return userMapper.toUserDto(userService.save(user));
    }

    @Override
    public UserDto saveTeacher(CreateUserDto createUserDto) {
        User user = new User();
        Teacher savedTeacher = new Teacher();

        // converting to entity
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());

        if (createUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(createUserDto.getRoleId()));
        }

        if (createUserDto.getCreateTeacherDto() != null) {
            savedTeacher = teacherMapper.toTeacher(teacherDtoService.save(createUserDto.getCreateTeacherDto()));

            user.setTeacher(savedTeacher);
        }

        User savedUser = userService.save(user);
        savedTeacher.setUser(savedUser);
        teacherService.save(savedTeacher);

        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto saveStudent(CreateUserDto createUserDto) {
        User user = new User();
        Student savedStudent = new Student();

        // converting to entity
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());

        if (createUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(createUserDto.getRoleId()));
        }

        if (createUserDto.getCreateStudentDto() != null) {
            savedStudent = studentMapper.toStudent(studentDtoService.save(createUserDto.getCreateStudentDto()));

            user.setStudent(savedStudent);
        }

        User savedUser = userService.save(user);
        savedStudent.setUser(savedUser);
        studentService.save(savedStudent);

        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto update(Long id, UpdateUserDto updateUserDto) {
        User user = userService.findById(id);

        // converting to entity
        user.setEmail(updateUserDto.getEmail());

        if (updateUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(updateUserDto.getRoleId()));
        }

        return userMapper.toUserDto(userService.save(user));
    }

    @Override
    public UserDto updateTeacher(Long id, UpdateUserDto updateUserDto) {
        User user = userService.findById(id);

        // converting to entity
        user.setEmail(updateUserDto.getEmail());

        if (updateUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(updateUserDto.getRoleId()));
        }

        if (updateUserDto.getUpdateTeacherDto() != null) {
            user.setTeacher(teacherMapper.toTeacher(teacherDtoService.update(updateUserDto.getUpdateTeacherDto().getId(),
                    updateUserDto.getUpdateTeacherDto())));
        }

        return userMapper.toUserDto(userService.save(user));
    }

    @Override
    public UserDto updateStudent(Long id, UpdateUserDto updateUserDto) {
        User user = userService.findById(id);

        // converting to entity
        user.setEmail(updateUserDto.getEmail());

        if (updateUserDto.getRoleId() != null) {
            user.setRole(roleService.findById(updateUserDto.getRoleId()));
        }

        if (updateUserDto.getUpdateStudentDto() != null) {
            user.setStudent(studentMapper.toStudent(studentDtoService.update(updateUserDto.getUpdateStudentDto().getId(),
                    updateUserDto.getUpdateStudentDto())));
        }

        return userMapper.toUserDto(userService.save(user));
    }

    @Override
    public void updatePassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws InappropriatePasswordException {
        User user = userService.findById(id);

        String lowerCaseRegex = ".*[a-z].*";
        String upperCaseRegex = ".*[A-Z].*";
        String specSymbolRegex = ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*";

        Pattern lowerCasePattern = Pattern.compile(lowerCaseRegex);
        Pattern upperCasePattern = Pattern.compile(upperCaseRegex);
        Pattern specSymbolPattern = Pattern.compile(specSymbolRegex);

        Matcher lowerCaseValidator = lowerCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher upperCaseValidator = upperCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher specSymbolValidator = specSymbolPattern.matcher(updateUserPasswordDto.getNewPassword());

        if (!updateUserPasswordDto.getOldPassword().equals(user.getPassword()))
            throw new InappropriatePasswordException("Old password is incorrect!");
        else if (!updateUserPasswordDto.getNewPassword().equals(updateUserPasswordDto.getRepeatNewPassword()))
            throw new InappropriatePasswordException("New password doesn't match to repeat password!");
        else if (updateUserPasswordDto.getNewPassword().length() < 8)
            throw new InappropriatePasswordException("At least 8 characters!");
        else if (!(lowerCaseValidator.matches()))
            throw new InappropriatePasswordException("At least 1 lower case letter!");
        else if (!(upperCaseValidator.matches()))
            throw new InappropriatePasswordException("At least 1 upper case letter!");
        else if (!(specSymbolValidator.matches()))
            throw new InappropriatePasswordException("At least 1 spec symbol!");

        user.setPassword(updateUserPasswordDto.getNewPassword());

        userService.save(user);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    public void deleteTeacher(Long userId, Long teacherId) {
        teacherDtoService.delete(teacherId);
        userService.delete(userId);
    }

    @Override
    public void deleteStudent(Long userId, Long studentId) {
        studentDtoService.delete(studentId);
        userService.delete(userId);
    }
}