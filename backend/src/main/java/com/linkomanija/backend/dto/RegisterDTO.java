package com.linkomanija.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterDTO {
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String phone_number;
    private Date date_of_birth;

  public String getUsername() {
    return username;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public Date getDate_of_birth() {
    return date_of_birth;
  }
}
