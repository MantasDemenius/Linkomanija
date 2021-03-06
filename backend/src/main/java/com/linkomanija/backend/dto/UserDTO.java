package com.linkomanija.backend.dto;

import com.linkomanija.backend.domain.UserAdmin;
import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import lombok.Data;

@Data
public class UserDTO {
  private UserAdmin userAdmin;
  private UserClient userClient;
  private UserEmployee userEmployee;
  private String role;
  private Long id;

  public UserDTO(UserAdmin userAdmin, UserClient userClient, UserEmployee userEmployee, String role, Long id) {
    this.userAdmin = userAdmin;
    this.userClient = userClient;
    this.userEmployee = userEmployee;
    this.role = role;
    this.id = id;
  }
}
