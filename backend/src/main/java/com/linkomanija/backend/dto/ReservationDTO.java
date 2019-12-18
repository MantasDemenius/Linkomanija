package com.linkomanija.backend.dto;

import java.util.Date;

public class ReservationDTO {
  private Long id;
  private Date creation_date;
  private int seat_row;
  private int seat_collumn;
  private double price;

  private String movie_start;
  private String movie_end;

  private boolean ticket_state;
  private Long user_client_id;
  private Long session_id;

  public ReservationDTO(Long id, Date creation_date, int seat_row, int seat_collumn, double price, String movie_start, String movie_end, boolean ticket_state, Long user_client_id, Long session_id) {
    this.id = id;
    this.creation_date = creation_date;
    this.seat_row = seat_row;
    this.seat_collumn = seat_collumn;
    this.price = price;
    this.movie_start = movie_start;
    this.movie_end = movie_end;
    this.ticket_state = ticket_state;
    this.user_client_id = user_client_id;
    this.session_id = session_id;
  }

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

  public String getMovie_start() {
    return movie_start;
  }

  public String getMovie_end() {
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

  public void setCreation_date(Date creation_date) {
    this.creation_date = creation_date;
  }
}
