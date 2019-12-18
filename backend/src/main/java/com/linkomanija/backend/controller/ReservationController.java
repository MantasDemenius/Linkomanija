package com.linkomanija.backend.controller;

import com.itextpdf.text.DocumentException;
import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.dto.ReservationDTO;
import com.linkomanija.backend.mail.Mail;
import com.linkomanija.backend.pdf.PdfGenerator;
import com.linkomanija.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private PdfGenerator pdfGenerator;

  @Autowired
  private Mail mail;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Reservation addReservation(@RequestBody ReservationDTO reservationDTO) throws IOException, DocumentException, MessagingException {
    Reservation reservation = reservationService.addReservation(reservationDTO);
    if (reservation.isTicket_state()) {
      pdfGenerator.generateDocument(reservation, "invoice");
      pdfGenerator.generateDocument(reservation, "ticket");
      mail.sendDocuments(reservation);
    }
    return reservation;
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
