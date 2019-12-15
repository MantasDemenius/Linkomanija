package com.linkomanija.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class ReservationDTO {
  private Long id;
  private Date creation_date;
  private int seat_row;
  private int seat_collumn;
  private double price;

  @JsonFormat(pattern="HH:mm")
  private Timestamp movie_start;

  @JsonFormat(pattern="HH:mm")
  private Timestamp movie_end;

  private boolean ticket_state;
  private Long user_client_id;
  private Long session_id;

  public Long getId() {
    return id;
  }

  public Date getCreation_date() {
    return creation_date;
  }

  public int getSeat_row() {
    return seat_row;
  }

  public int getSeat_collumn() {
    return seat_collumn;
  }

  public double getPrice() {
    return price;
  }

  public Timestamp getMovie_start() {
    return movie_start;
  }

  public Timestamp getMovie_end() {
    return movie_end;
  }

  public boolean isTicket_state() {
    return ticket_state;
  }

  public Long getUser_client_id() {
    return user_client_id;
  }

  public Long getSession_id() {
    return session_id;
  }
}
