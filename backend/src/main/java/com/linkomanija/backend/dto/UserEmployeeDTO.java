package com.linkomanija.backend.dto;

import java.util.Date;

public class UserEmployeeDTO {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String name;
  private String surname;
  private Date born_date;
  private String phone_number;
  private Long theater_id;

  public Long getTheater_id() {
    return theater_id;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public Date getBorn_date() {
    return born_date;
  }

  public String getPhone_number() {
    return phone_number;
  }
}