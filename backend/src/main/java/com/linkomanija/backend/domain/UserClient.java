package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.RegisterDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_client")
public class UserClient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;
  private String email;
  private String name;
  private String surname;
  private Date born_date;
  private String phone_number;

  public UserClient(RegisterDTO registerDTO) {
    this.username = registerDTO.getUsername();
    this.password = registerDTO.getPassword();
    this.email = registerDTO.getEmail();
    this.name = registerDTO.getName();
    this.surname = registerDTO.getLastname();
    this.born_date = registerDTO.getDate_of_birth();
    this.phone_number = registerDTO.getPhone_number();
  }

  public UserClient() {}

  public String getEmail() {
    return email;
  }

  public boolean isPasswordCorrect(String password) {
    return this.password.equals(password);
  }
}
