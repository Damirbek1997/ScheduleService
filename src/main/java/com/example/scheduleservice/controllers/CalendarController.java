//package com.example.scheduleservice.controllers;
//
//import com.example.scheduleservice.entities.Calendar;
//import com.example.scheduleservice.services.impl.DefaultCalendarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/calendar")
//public class CalendarController {
//    @Autowired
//    private DefaultCalendarService defaultCalendarService;
//
//    // API to find all items
//    @GetMapping("/getAll")
//    private List<Calendar> findAllCalendar() {
//       return defaultCalendarService.findAllCalendar();
//    }
//
//    // API to find item by id
//    @GetMapping("/getOne/{id}")
//    private Optional<Calendar> findCalendarById(@PathVariable("id") Long id) {
//        return defaultCalendarService.findCalendarById(id);
//    }
//
//    // API to update item by id
//    @PutMapping("/update/{id}")
//    private Calendar changeCalendarById(@PathVariable("id") Long id, @RequestBody Calendar newCalendar) throws Exception {
//        return defaultCalendarService.changeCalendarById(id, newCalendar);
//    }
//
//    // API to create new calendar
//    @PostMapping("/add")
//    private void createCalendar(@RequestBody Calendar newCalendar) {
//        defaultCalendarService.saveCalendar(newCalendar);
//    }
//
//    // API to delete calendar by id
//    @DeleteMapping("/delete/{id}")
//    private void deleteCalendarById(@PathVariable("id") Long id) {
//        defaultCalendarService.deleteCalendar(id);
//    }
//}
