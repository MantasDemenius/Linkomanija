package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserEmployeeService userEmployeeService;

  @PostMapping(value = "employee", consumes = "application/json", produces = "application/json")
  public UserEmployee addEmployee(@RequestBody UserEmployeeDTO userEmployeeDTO) {
    return userEmployeeService.addEmployee(userEmployeeDTO);
  }

  @GetMapping(value = "employee/{id}", produces = "application/json")
  public UserEmployee getEmployee(@PathVariable(value = "id") Long id) {
    return userEmployeeService.getEmployeeById(id);
  }

  @GetMapping(value = "employee", produces = "application/json")
  public List<UserEmployee> getAllEmployees() {
    return userEmployeeService.getAllEmployees();
  }
}
