package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.dto.RegisterDTO;
import com.linkomanija.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public UserClient login(@RequestBody RegisterDTO registerDTO) {
    return userService.register(registerDTO);
  }
}
