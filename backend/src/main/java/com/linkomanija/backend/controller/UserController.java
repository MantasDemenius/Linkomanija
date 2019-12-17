package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.UserDTO;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.service.UserClientService;
import com.linkomanija.backend.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<UserEmployee> addEmployee(@RequestBody UserEmployeeDTO userEmployeeDTO) {
    UserEmployee userEmployee = userEmployeeService.addEmployee(userEmployeeDTO);
    if (userEmployee == null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(userEmployee);
  }

  @PostMapping(value = "client", consumes = "application/json", produces = "application/json")
  public ResponseEntity<UserClient> addClient(@RequestBody UserClient userClient) {
    userClient = userClientService.addClient(userClient);
    if (userClient == null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(userClient);
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
