//package com.example.scheduleservice.controllers;
//
//import com.example.scheduleservice.entities.Group;
//import com.example.scheduleservice.services.impl.DefaultGroupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("group")
//public class GroupController {
//    @Autowired
//    private DefaultGroupService defaultGroupService;
//
//    // API to find all items
//    @GetMapping("/getAll")
//    private List<Group> findAllGroups() {
//        return defaultGroupService.findAllGroups();
//    }
//
//    // API to find group by id
//    @GetMapping("/getOne/{id}")
//    private Optional<Group> findGroupById(@PathVariable("id") Long id) {
//        return defaultGroupService.findGroupById(id);
//    }
//
//    // API to update group by id
//    @PutMapping("/update/{id}")
//    private Group changeGroupById(@PathVariable("id") Long id, @RequestBody Group newGroup) throws Exception {
//        return defaultGroupService.changeGroupById(id, newGroup);
//    }
//
//    // API to create new group
//    @PostMapping("/add")
//    private void createGroup(@RequestBody Group newGroup) {
//        defaultGroupService.saveGroup(newGroup);
//    }
//
//    // API to delete group by id
//    private void deleteGroupById(@PathVariable("id") Long id) {
//        defaultGroupService.deleteGroup(id);
//    }
//}