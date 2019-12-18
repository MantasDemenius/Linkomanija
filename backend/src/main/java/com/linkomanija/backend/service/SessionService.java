package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.*;
import com.linkomanija.backend.dto.EmptySeatDTO;
import com.linkomanija.backend.dto.SessionDTO;
import com.linkomanija.backend.repository.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SessionService {

  private SessionRepository sessionRepository;
  private LanguageRepository languageRepository;
  private MovieHallRepository movieHallRepository;
  private MovieRepository movieRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  public SessionService(SessionRepository sessionRepository, LanguageRepository languageRepository, MovieHallRepository movieHallRepository, MovieRepository movieRepository) {
    this.sessionRepository = sessionRepository;
    this.languageRepository = languageRepository;
    this.movieHallRepository = movieHallRepository;
    this.movieRepository = movieRepository;
  }

  public ResponseEntity<Boolean> addSession(SessionDTO sessionDTO) {
    Movie movieById = movieRepository.findById(sessionDTO.getMovie_id()).orElse(new Movie());
    Language language = movieById.getLanguage();
    int empty_seats = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall()).getSeatCount();

    String start = sessionDTO.getSession_start();
    int length = movieById.getMovie_length();

    String end = findSessionEnd(start, length);

    sessionDTO.setSession_end(end);
    sessionDTO.setEmpty_spaces(empty_seats);
    sessionDTO.setLength(length);

    MovieHall movieHallById = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall());
    Date initialDate = sessionDTO.getSession_date();
    for (int i = 0; i < sessionDTO.getSession_count(); i++) {
      Session session = new Session(sessionDTO, language, movieById, movieHallById);
      sessionRepository.save(session);
      initialDate = DateUtils.addDays(initialDate, 1);
      session.setSession_date(initialDate);
    }
    return ResponseEntity.status(HttpStatus.OK).body(true);
  }

  private String findSessionEnd(String start, int length) {
    int length_hours = length / 60;
    int length_minutes = length % 60;
    int start_hours = Integer.parseInt(start.split(":")[0]);
    int start_minutes = Integer.parseInt(start.split(":")[1]);

    int final_start_hours = start_hours+length_hours;
    int final_start_minutes = start_minutes+length_minutes;
    final_start_hours += final_start_minutes / 60;
    final_start_minutes %= 60;
    return String.format("%d:%d", final_start_hours, final_start_minutes);
  }

  public List<Session> getAllSessions() {
    return sessionRepository.findAll();
  }

  public Session getSessionById(Long id) {
    return sessionRepository.findById(id).orElse(new Session());
  }

  public Session editSession(SessionDTO sessionDTO) {
    Session session = sessionRepository.findById(sessionDTO.getId()).orElse(new Session());
    Movie movieById = movieRepository.findById(sessionDTO.getMovie_id()).orElse(new Movie());
    String sessionEnd = findSessionEnd(sessionDTO.getSession_start(), movieById.getMovie_length());
    sessionDTO.setSession_end(sessionEnd);
    MovieHall movieHallById = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall());
    session.updateValues(sessionDTO, movieById, movieHallById);
    return sessionRepository.save(session);
  }

  public Session deleteSession(Long id) {
    Session session = sessionRepository.findById(id).orElse(new Session());
    sessionRepository.delete(session);
    return session;
  }

  public List<List<EmptySeatDTO>> getEmptySeats(Long session_id) {
    List<Reservation> reservations = reservationRepository.findBySessionId(session_id);
    Session session = sessionRepository.findById(session_id).orElse(new Session());
    MovieHall movieHall = session.getMovieHall();
    int rows = 10, seats = 15;
    if (movieHall.getSeatCount() == 450) {
      rows = 15;
      seats = 30;
    }
    List<List<EmptySeatDTO>> SEATS = new ArrayList<>();
    int uniqueid = 0;
    for (int i = 0; i < rows; i++) {
      SEATS.add(new ArrayList<>());
      for (int j = 0; j < seats; j++) {
        SEATS.get(i).add(new EmptySeatDTO(i+1,j+1,uniqueid));
        uniqueid++;
      }
    }

    for (Reservation reservation : reservations) {
      int seat = reservation.getSeat_collumn();
      int row = reservation.getSeat_row();
      SEATS.get(row-1).set(seat-1, new EmptySeatDTO(-1,-1,-1));
    }

    List<EmptySeatDTO> emptySeats = new ArrayList<>();
    List<List<EmptySeatDTO>> SEATS_FINAL = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      SEATS_FINAL.set(i, new ArrayList<>());
      for (int j = 0; j < seats; j++) {
        if (SEATS.get(i).get(j).getRow() == -1)
          continue;
        SEATS_FINAL.get(i).set(j, SEATS.get(i).get(j));
      }
    }
    return SEATS;
  }
}
