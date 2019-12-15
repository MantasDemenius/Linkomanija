package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.service.UserClientService;
import com.linkomanija.backend.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

  private UserEmployeeService userEmployeeService;
  private UserClientService userClientService;

  @Autowired
  public UserController(UserEmployeeService userEmployeeService, UserClientService userClientService) {
    this.userEmployeeService = userEmployeeService;
    this.userClientService = userClientService;
  }

  @PostMapping(value = "employee", consumes = "application/json", produces = "application/json")
  public UserEmployee addEmployee(@RequestBody UserEmployeeDTO userEmployeeDTO) {
    return userEmployeeService.addEmployee(userEmployeeDTO);
  }

  @PostMapping(value = "client", consumes = "application/json", produces = "application/json")
  public UserClient addClient(@RequestBody UserClient userClient) {
    return userClientService.addClient(userClient);
  }

  @PostMapping(value = "client/edit", consumes = "application/json", produces = "application/json")
  public UserClient editProfile(@RequestBody UserClient userClient) {
    return userClientService.editProfile(userClient);
  }

  @GetMapping(value = "employee/{id}", produces = "application/json")
  public UserEmployee getEmployee(@PathVariable(value = "id") Long id) {
    return userEmployeeService.getEmployeeById(id);
  }

  @GetMapping(value = "client/{id}", produces = "application/json")
  public UserClient getClient(@PathVariable(value = "id") Long id) {
    return userClientService.getClientById(id);
  }

  @GetMapping(value = "employee", produces = "application/json")
  public List<UserEmployee> getAllEmployees() {
    return userEmployeeService.getAllEmployees();
  }

  @GetMapping(value = "client", produces = "application/json")
  public List<UserClient> getAllClients() {
    return userClientService.getAllClients();
  }

  @DeleteMapping(value = "employee/{id}", produces = "application/json")
  public UserEmployee deleteEmployeeById(@PathVariable(value = "id") Long id) {
    return userEmployeeService.deleteEmployeeById(id);
  }

  @DeleteMapping(value = "client/{id}", produces = "application/json")
  public UserClient deleteClientById(@PathVariable(value = "id") Long id) {
    return userClientService.deleteProfileById(id);
  }
}
