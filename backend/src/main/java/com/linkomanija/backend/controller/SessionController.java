package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.Session;
import com.linkomanija.backend.dto.SessionDTO;
import com.linkomanija.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/session")
public class SessionController {

  @Autowired
  SessionService sessionService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<Boolean> addSession(@RequestBody SessionDTO sessionDTO) {
    return sessionService.addSession(sessionDTO);
  }

  @PostMapping(value = "edit", produces = "application/json")
  public Session editSession(@RequestBody SessionDTO sessionDTO) {
    return sessionService.editSession(sessionDTO);
  }

  @DeleteMapping(value = "{id}", produces = "application/json")
  public Session deleteSession(@PathVariable(name = "id") Long id) {
    return sessionService.deleteSession(id);
  }

  @GetMapping(value = "{id}", produces = "application/json")
  public Session getSession(@PathVariable(name = "id") Long id) {
    return sessionService.getSessionById(id);
  }

  @GetMapping(produces = "application/json")
  public List<Session> getAllSessions() {
    return sessionService.getAllSessions();
  }
}
