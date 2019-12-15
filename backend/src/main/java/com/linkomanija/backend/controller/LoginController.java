package com.linkomanija.backend.controller;

import com.linkomanija.backend.dto.LoginDTO;
import com.linkomanija.backend.dto.UserDTO;
import com.linkomanija.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public UserDTO login(@RequestBody LoginDTO loginDTO) {
    return userService.login(loginDTO);
  }
}
