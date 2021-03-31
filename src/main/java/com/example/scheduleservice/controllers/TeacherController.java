//package com.example.scheduleservice.controllers;
//
//import com.example.scheduleservice.entities.Teacher;
//import com.example.scheduleservice.services.impl.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/teacher")
//public class TeacherController {
//    @Autowired
//    private TeacherService teacherService;
//
//    // API to find all teachers
//    @GetMapping("/getAll")
//    private List<Teacher> findAllTeachers() {
//        return teacherService.findAllTeachers();
//    }
//
//    // API to find teacher by id
//    @GetMapping("/getOne/{id}")
//    private Optional<Teacher> findTeacherById(@PathVariable("id") Long id) {
//        return teacherService.findTeacherById(id);
//    }
//
//    // API to update teacher by id
//    @PutMapping("/update/{id}")
//    private Teacher changeTeacherById(@PathVariable("id") Long id, @RequestBody Teacher newTeacher) throws Exception {
//        return teacherService.changeTeacherById(id, newTeacher);
//    }
//
//    // API to create new teacher
//    @PostMapping("/add")
//    private void createTeacher(@RequestBody Teacher newTeacher) {
//        teacherService.saveTeacher(newTeacher);
//    }
//
//    // API to delete teacher by id
//    @DeleteMapping("/delete/{id}")
//    private void deleteTeacherById(@PathVariable("id") Long id) {
//        teacherService.deleteTeacherById(id);
//    }
//}
