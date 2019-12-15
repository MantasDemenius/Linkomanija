package com.linkomanija.backend.domain;

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
  private Date born_date;
  private String phone_number;

  public boolean isPasswordCorrect(String password) {
    return this.password.equals(password);
  }
}
