package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.*;
import com.linkomanija.backend.dto.SessionDTO;
import com.linkomanija.backend.repository.LanguageRepository;
import com.linkomanija.backend.repository.MovieHallRepository;
import com.linkomanija.backend.repository.MovieRepository;
import com.linkomanija.backend.repository.SessionRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

  private SessionRepository sessionRepository;
  private LanguageRepository languageRepository;
  private MovieHallRepository movieHallRepository;
  private MovieRepository movieRepository;

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
    int length_hours = length / 60;
    int length_minutes = length % 60;
    int start_hours = Integer.parseInt(start.split(":")[0]);
    int start_minutes = Integer.parseInt(start.split(":")[1]);

    int final_start_hours = start_hours+length_hours;
    int final_start_minutes = start_minutes+length_minutes;
    final_start_hours += final_start_minutes / 60;
    final_start_minutes %= 60;
    String end = String.format("%d:%d", final_start_hours, final_start_minutes);

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

  public List<Session> getAllSessions() {
    return sessionRepository.findAll();
  }

  public Session getSessionById(Long id) {
    return sessionRepository.findById(id).orElse(new Session());
  }

  public Session editSession(SessionDTO sessionDTO) {
    Session session = sessionRepository.findById(sessionDTO.getId()).orElse(new Session());
    Language languageById = languageRepository.findById(sessionDTO.getLanguage_id()).orElse(new Language());
    Movie movieById = movieRepository.findById(sessionDTO.getMovie_id()).orElse(new Movie());
    MovieHall movieHallById = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall());
    session.updateValues(sessionDTO, languageById, movieById, movieHallById);
    return sessionRepository.save(session);
  }

  public Session deleteSession(Long id) {
    Session session = sessionRepository.findById(id).orElse(new Session());
    sessionRepository.delete(session);
    return session;
  }
}
