//package com.example.scheduleservice.controllers;
//
//import com.example.scheduleservice.entities.Subject;
//import com.example.scheduleservice.services.impl.DefaultSubjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/subject")
//public class SubjectController {
//    @Autowired
//    private DefaultSubjectService defaultSubjectService;
//
//    // API to find all subjects
//    @GetMapping("/getAll")
//    private List<Subject> findAllSubjects() {
//        return defaultSubjectService.findAllSubjects();
//    }
//
//    // API to find subject by id
//    @GetMapping("/getOne/{id}")
//    private Optional<Subject> findSubjectById(@PathVariable("id") Long id) {
//        return defaultSubjectService.findSubjectById(id);
//    }
//
//    // API to update subject by id
//    @PutMapping("/update/{id}")
//    private Subject changeSubjectById(@PathVariable("id") Long id, @RequestBody Subject newSubject) throws Exception {
//        return defaultSubjectService.changeSubjectById(id, newSubject);
//    }
//
//    // API to create new subject
//    @PostMapping("/add")
//    private void createSubject(@RequestBody Subject nweSubject) {
//        defaultSubjectService.save(nweSubject);
//    }
//
//    // API to delete subject by id
//    @DeleteMapping("/delete/{id}")
//    private void deleteSubjectById(@PathVariable("id") Long id) {
//        defaultSubjectService.deleteSubjectById(id);
//    }
//}
