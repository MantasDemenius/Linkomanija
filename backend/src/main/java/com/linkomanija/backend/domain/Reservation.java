package com.linkomanija.backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "rezervation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date creation_date;
  private int seat_row;
  private int seat_collumn;
  private double price;
  private Timestamp movie_start;
  private Timestamp movie_end;
  private boolean ticket_state;
  private Long user_client_id;
  private Long session_id;
}
