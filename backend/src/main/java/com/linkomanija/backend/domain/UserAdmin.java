package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_admin")
public class UserAdmin {
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

  public Long getId() {
    return id;
  }

  public UserAdmin(Long id, String username, String password, String email, String name, String surname, Date born_date, String phone_number) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.born_date = born_date;
    this.phone_number = phone_number;
  }

  public UserAdmin() {}

  public boolean isPasswordCorrect(String password) {
    return this.password.equals(password);
  }
}
