package com.linkomanija.backend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "language")
public class Language {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
}
