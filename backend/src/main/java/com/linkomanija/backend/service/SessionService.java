package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Session;
import com.linkomanija.backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
  private SessionRepository sessionRepository;

  @Autowired
  public SessionService(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  public Session save(Session session) {
    return sessionRepository.save(session);
  }

  public List<Session> getSessions() {
    return sessionRepository.findAll();
  }

  public Session getSession(Long id) {
    return sessionRepository.findById(id).orElse(new Session());
  }
}
