package com.linkomanija.backend.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
