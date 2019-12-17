package com.linkomanija.backend.controller;

import com.linkomanija.backend.dto.LoginDTO;
import com.linkomanija.backend.dto.UserDTO;
import com.linkomanija.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
    UserDTO userDTO = userService.login(loginDTO);
    if (userDTO == null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(userDTO);
  }
}
