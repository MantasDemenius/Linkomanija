package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.dto.ReservationDTO;
import com.linkomanija.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

  @Autowired
  private ReservationService reservationService;

  @PostMapping(produces = "application/json")
  public Reservation addReservation(@RequestBody ReservationDTO reservationDTO) {
    return reservationService.addReservation(reservationDTO);
  }

  @PostMapping(value = "change-seat", produces = "application/json")
  public Reservation changeSeat(@RequestBody ReservationDTO reservationDTO) {
    return reservationService.changeSeat(reservationDTO);
  }

  @GetMapping(produces = "application/json")
  public List<Reservation> getAllReservations() {
    return reservationService.getAllReservations();
  }

  @GetMapping(value = "{id}", produces = "application/json")
  public Reservation getReservation(@PathVariable(name = "id") Long id) {
    return reservationService.getReservationById(id);
  }

  @GetMapping(value = "client/{user_client_id}", produces = "application/json")
  public List<Reservation> getAllReservationsByClientId(@PathVariable(name = "user_client_id") Long user_client_id) {
    return reservationService.getAllReservationsByClientId(user_client_id);
  }

  @DeleteMapping(value = "{id}", produces = "application/json")
  public Reservation deleteReservation(@PathVariable(name = "id") Long id) {
    return reservationService.deleteReservationById(id);
  }

}
