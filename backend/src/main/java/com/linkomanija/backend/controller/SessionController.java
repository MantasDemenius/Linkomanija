package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.Session;
import com.linkomanija.backend.dto.SessionDTO;
import com.linkomanija.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/session")
public class SessionController {
  @Autowired
  SessionService sessionService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Session addSession(@RequestBody SessionDTO sessionDTO) {
    return sessionService.addSession(sessionDTO);
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public Session getSession(@PathVariable(name = "id") Long id) {
    return sessionService.getSessionById(id);
  }

  @GetMapping(produces = "application/json")
  public List<Session> getAllSessions() {
    return sessionService.getAllSessions();
  }
}
