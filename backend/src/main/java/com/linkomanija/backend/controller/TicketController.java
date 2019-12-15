package com.linkomanija.backend.controller;

import com.itextpdf.text.DocumentException;
import com.linkomanija.backend.domain.Reservation;
import com.linkomanija.backend.dto.ReservationDTO;
import com.linkomanija.backend.pdf.PdfGenerator;
import com.linkomanija.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

  private ReservationService reservationService;
  private PdfGenerator pdfGenerator;

  @Autowired
  public TicketController(ReservationService reservationService, PdfGenerator pdfGenerator) {
    this.reservationService = reservationService;
    this.pdfGenerator = pdfGenerator;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Reservation buyTicket(@RequestBody ReservationDTO reservationDTO) throws IOException, DocumentException {
    Reservation reservation = reservationService.addReservation(reservationDTO);
    pdfGenerator.generateDocument(reservation, "invoice");
    pdfGenerator.generateDocument(reservation, "ticket");
    return reservation;
  }


}
