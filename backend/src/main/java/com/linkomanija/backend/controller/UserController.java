package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.service.UserEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
  private UserEmployeeService userEmployeeService;

  public UserController(UserEmployeeService userEmployeeService) {
    this.userEmployeeService = userEmployeeService;
  }

  @PostMapping(value = "/employee/add", consumes = "application/json", produces = "application/json")
  public UserEmployee addEmployee(@RequestBody UserEmployee userEmployee) {
    return userEmployeeService.save(userEmployee);
  }

  @GetMapping(value = "/employee/{id}")
  public UserEmployee getEmployee(@PathVariable(value = "id") Long id) {
    return userEmployeeService.getEmployee(id);
  }
}
