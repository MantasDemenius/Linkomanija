package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linkomanija.backend.dto.ReservationDTO;
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

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date creation_date;

  private int seat_row;
  private int seat_collumn;
  private double price;
  private Timestamp movie_start;
  private Timestamp movie_end;
  private boolean ticket_state;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_client_id")
  private UserClient userClient;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "session_id")
  private Session session;

  public Reservation(ReservationDTO reservationDTO, UserClient userClient, Session session) {
    this.creation_date = reservationDTO.getCreation_date();
    this.seat_row = reservationDTO.getSeat_row();
    this.seat_collumn = reservationDTO.getSeat_collumn();
    this.price = reservationDTO.getPrice();
    this.movie_start = reservationDTO.getMovie_start();
    this.movie_end = reservationDTO.getMovie_end();
    this.ticket_state = reservationDTO.isTicket_state();
    this.userClient = userClient;
    this.session = session;
  }

  public Reservation() {}

  public Long getId() {
    return id;
  }

  public UserClient getUserClient() {
    return userClient;
  }

  public void changeSeat(int seat_row, int seat_collumn) {
    this.seat_row = seat_row;
    this.seat_collumn = seat_collumn;
  }

  public boolean isTicket_state() {
    return ticket_state;
  }

  public int getSeat_collumn() {
    return seat_collumn;
  }

  public int getSeat_row() {
    return seat_row;
  }
}
