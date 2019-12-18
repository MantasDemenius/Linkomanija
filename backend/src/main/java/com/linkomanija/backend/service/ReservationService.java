package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.domain.Session;
import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.dto.ReservationDTO;
import com.linkomanija.backend.repository.ReservationRepository;
import com.linkomanija.backend.repository.SessionRepository;
import com.linkomanija.backend.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
  private ReservationRepository reservationRepository;
  private UserClientRepository userClientRepository;
  private SessionRepository sessionRepository;

  @Autowired
  public ReservationService(ReservationRepository reservationRepository, UserClientRepository userClientRepository, SessionRepository sessionRepository) {
    this.reservationRepository = reservationRepository;
    this.userClientRepository = userClientRepository;
    this.sessionRepository = sessionRepository;
  }

  public Reservation addReservation(ReservationDTO reservationDTO) {
    UserClient userClientById = userClientRepository.findById(reservationDTO.getUser_client_id()).orElse(new UserClient());
    Session sessionById = sessionRepository.findById(reservationDTO.getSession_id()).orElse(new Session());
    Date creation_date = new Date(System.currentTimeMillis());
    reservationDTO.setCreation_date(creation_date);
    Reservation reservation = new Reservation(reservationDTO, userClientById, sessionById);
    return reservationRepository.save(reservation);
  }

  public List<Reservation> getAllReservations() {
    return reservationRepository.findAll();
  }

  public List<Reservation> getAllReservationsByClientId(Long user_client_id) {
    List<Reservation> reservations = reservationRepository.findByUserClientId(user_client_id);
    return reservations.stream()
      .filter(Reservation::isTicket_state)
      .collect(Collectors.toList());
  }

  public Reservation getReservationById(Long id) {
    return reservationRepository.findById(id).orElse(new Reservation());
  }

  public Reservation deleteReservationById(Long id) {
    Reservation reservation = reservationRepository.findById(id).orElse(new Reservation());
    reservationRepository.delete(reservation);
    return reservation;
  }

  public Reservation changeSeat(ReservationDTO reservationDTO) {
    Reservation reservation = reservationRepository.findById(reservationDTO.getId()).orElse(new Reservation());
    reservation.changeSeat(reservationDTO.getSeat_row(), reservationDTO.getSeat_collumn());
    return reservationRepository.save(reservation);
  }

  public List<Reservation> findValidTicketsByUserId(Long user_id) {
    List<Reservation> tickets = reservationRepository.findByUserClientId(user_id)
      .stream()
      .filter(Reservation::isTicket_state)
      .collect(Collectors.toList());
    return tickets;

  }
}
