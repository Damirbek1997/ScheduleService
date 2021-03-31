//package com.example.scheduleservice.controllers;
//
//import com.example.scheduleservice.entities.Schedule;
//import com.example.scheduleservice.services.impl.ScheduleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/schedule")
//public class ScheduleController {
//    private final ScheduleService scheduleService;
//
//    @Autowired
//    public ScheduleController(ScheduleService scheduleService) {
//        this.scheduleService = scheduleService;
//    }
//
//    @GetMapping("/getAll")
//    private List<Schedule> findAllSchedule() {
//        return scheduleService.findAllSchedule();
//    }
//
//    @GetMapping("/getOne/{id}")
//    private Optional<Schedule> findScheduleById(@PathVariable("id") Long id) {
//        return scheduleService.findScheduleById(id);
//    }
//
//    @PutMapping("/update/{id}")
//    private Schedule changeScheduleById(@PathVariable("id") Long id, @RequestBody Schedule newSchedule) throws Exception {
//        return scheduleService.changeScheduleById(id, newSchedule);
//    }
//
//    @PostMapping("/add")
//    private void createSchedule(@RequestBody Schedule newSchedule) {
//        scheduleService.save(newSchedule);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    private void deleteScheduleById(@PathVariable("id") Long id) {
//        scheduleService.deleteScheduleById(id);
//    }
//}
