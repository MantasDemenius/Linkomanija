package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
  private ReservationRepository reservationRepository;

  @Autowired
  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  List<Reservation> getReservations() {
    return reservationRepository.findAll();
  }
}
