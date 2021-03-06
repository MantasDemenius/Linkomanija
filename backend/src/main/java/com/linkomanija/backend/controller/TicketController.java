package com.linkomanija.backend.controller;

import com.itextpdf.text.DocumentException;
import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.dto.ReservationDTO;
import com.linkomanija.backend.mail.Mail;
import com.linkomanija.backend.pdf.PdfGenerator;
import com.linkomanija.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

  private ReservationService reservationService;
  private PdfGenerator pdfGenerator;
  private Mail mail;

  @Autowired
  public TicketController(ReservationService reservationService, PdfGenerator pdfGenerator, Mail mail) {
    this.reservationService = reservationService;
    this.pdfGenerator = pdfGenerator;
    this.mail = mail;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Reservation buyTicket(@RequestBody ReservationDTO reservationDTO) throws IOException, DocumentException, MessagingException {
    Reservation reservation = reservationService.addReservation(reservationDTO);
    pdfGenerator.generateDocument(reservation, "invoice");
    pdfGenerator.generateDocument(reservation, "ticket");
    mail.sendDocuments(reservation);
    return reservation;
  }

  @PostMapping(value = "{user_id}")
  public ResponseEntity<String> sendTickets(@PathVariable(name = "user_id") Long user_id) throws IOException, DocumentException, MessagingException {
    List<Reservation> validTickets = reservationService.findValidTicketsByUserId(user_id);
    for (Reservation reservation : validTickets) {
      pdfGenerator.generateDocument(reservation, "ticket");
      mail.sendDocuments(reservation);
    }
    return ResponseEntity.ok(validTickets.size() + " tickets have been sent");
  }


}
