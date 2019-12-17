package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.UserAdmin;
import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.repository.UserAdminRepository;
import com.linkomanija.backend.repository.UserClientRepository;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

  private UserClientRepository userClientRepository;
  private UserAdminRepository userAdminRepository;
  private UserEmployeeRepository userEmployeeRepository;

  @Autowired
  public UserClientService(UserClientRepository userClientRepository, UserAdminRepository userAdminRepository, UserEmployeeRepository userEmployeeRepository) {
    this.userAdminRepository = userAdminRepository;
    this.userClientRepository = userClientRepository;
    this.userEmployeeRepository = userEmployeeRepository;
  }

  public UserClient addClient(UserClient userClientDTO) {
    String username = userClientDTO.getUsername();

    UserAdmin userAdmin = userAdminRepository.findByUsername(username);
    UserEmployee userEmployee = userEmployeeRepository.findByUsername(username);
    UserClient userClient = userClientRepository.findByUsername(username);

    if (userAdmin == null && userEmployee == null && userClient == null) {
      return userClientRepository.save(userClientDTO);
    }
    return null;
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
