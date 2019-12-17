package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.*;
import com.linkomanija.backend.dto.SessionDTO;
import com.linkomanija.backend.repository.LanguageRepository;
import com.linkomanija.backend.repository.MovieHallRepository;
import com.linkomanija.backend.repository.MovieRepository;
import com.linkomanija.backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public Session addSession(SessionDTO sessionDTO) {
    Movie movieById = movieRepository.findById(sessionDTO.getMovie_id()).orElse(new Movie());
    Language language = movieById.getLanguage();
    MovieHall movieHallById = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall());
    Session session = new Session(sessionDTO, language, movieById, movieHallById);
    return sessionRepository.save(session);
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
