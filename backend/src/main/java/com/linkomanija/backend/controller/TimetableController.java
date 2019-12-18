package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.Timetable;
import com.linkomanija.backend.dto.TimetableDTO;
import com.linkomanija.backend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

  @Autowired
  private TimetableService timetableService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Timetable addTimetable(@RequestBody TimetableDTO timetableDTO) {
    return timetableService.addTimetable(timetableDTO);
  }

  @PostMapping(value = "edit", consumes = "application/json", produces = "application/json")
  public Timetable editTimetable(@RequestBody TimetableDTO timetableDTO) {
    return timetableService.editTimetable(timetableDTO);
  }

  @GetMapping(value = "{id}", produces = "application/json")
  public List<Timetable> getAllTimetablesByEmployeeId(@PathVariable(name = "id") Long id) {
    return timetableService.getAllTimetablesByEmployeeId(id);
  }

  @GetMapping(value = "all", produces = "application/json")
  public List<Timetable> getAllTimetables() {
    return timetableService.getAllTimetables();
  }
}
