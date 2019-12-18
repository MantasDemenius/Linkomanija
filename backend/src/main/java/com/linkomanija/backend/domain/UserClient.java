package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

  public UserClient(String username, String password, String email, String name, String surname, Date born_date, String phone_number) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.born_date = born_date;
    this.phone_number = phone_number;
  }

  public String getUsername() {
    return username;
  }

  public UserClient() {}

  public String getEmail() {
    return email;
  }

  public Long getId() {
    return id;
  }

  public boolean isPasswordCorrect(String password) {
    return this.password.equals(password);
  }
}
