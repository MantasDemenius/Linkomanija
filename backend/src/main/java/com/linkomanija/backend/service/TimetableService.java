package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Timetable;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.TimetableDTO;
import com.linkomanija.backend.repository.TimetableRepository;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

  private UserEmployeeRepository userEmployeeRepository;
  private TimetableRepository timetableRepository;

  @Autowired
  public TimetableService(UserEmployeeRepository userEmployeeRepository, TimetableRepository timetableRepository) {
    this.userEmployeeRepository = userEmployeeRepository;
    this.timetableRepository = timetableRepository;
  }

  public Timetable addTimetable(TimetableDTO timetableDTO) {
    UserEmployee userEmployeeById = userEmployeeRepository.findById(timetableDTO.getUser_employee_id()).orElse(new UserEmployee());
    Timetable timetable = new Timetable(timetableDTO, userEmployeeById);
    return timetableRepository.save(timetable);
  }

  public List<Timetable> getAllTimetables() {
    return timetableRepository.findAll();
  }

  public List<Timetable> getAllTimetablesByEmployeeId(Long user_employee_id) {
    return timetableRepository.findByUserEmployeeId(user_employee_id);
  }

  public Timetable editTimetable(TimetableDTO timetableDTO) {
    Timetable timetable = timetableRepository.findById(timetableDTO.getId()).orElse(new Timetable());
    timetable.updateTimetable(timetableDTO);
    return timetableRepository.save(timetable);
  }

  public ResponseEntity<String> deleteTimetableById(Long id) {
    timetableRepository.delete(timetableRepository.findById(id).orElse(new Timetable()));
    return ResponseEntity.ok("Deletion is good");
  }
}
