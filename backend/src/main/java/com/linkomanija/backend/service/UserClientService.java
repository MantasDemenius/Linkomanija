package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

  @Autowired
  UserClientRepository userClientRepository;

  public UserClient addClient(UserClient userClient) {
    return userClientRepository.save(userClient);
  }

  public List<UserClient> getAllClients() {
    return userClientRepository.findAll();
  }

  public UserClient getClientById(Long id) {
    return userClientRepository.findById(id).orElse(new UserClient());
  }

  public UserClient editProfile(UserClient userClient) {
    return userClientRepository.save(userClient);
  }

  public UserClient deleteProfileById(Long id) {
    UserClient userClient = userClientRepository.findById(id).orElse(new UserClient());
    userClientRepository.delete(userClient);
    return userClient;
  }
}
