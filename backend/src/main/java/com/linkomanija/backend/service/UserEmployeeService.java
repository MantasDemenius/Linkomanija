package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.MovieTheatre;
import com.linkomanija.backend.domain.UserAdmin;
import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.repository.MovieTheatreRepository;
import com.linkomanija.backend.repository.UserAdminRepository;
import com.linkomanija.backend.repository.UserClientRepository;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserEmployeeService {

  private UserEmployeeRepository userEmployeeRepository;
  private MovieTheatreRepository movieTheatreRepository;
  private UserAdminRepository userAdminRepository;
  private UserClientRepository userClientRepository;

  @Autowired
  public UserEmployeeService(UserAdminRepository userAdminRepository, UserClientRepository userClientRepository, UserEmployeeRepository userEmployeeRepository, MovieTheatreRepository movieTheatreRepository) {
    this.userEmployeeRepository = userEmployeeRepository;
    this.movieTheatreRepository = movieTheatreRepository;
    this.userAdminRepository = userAdminRepository;
    this.userClientRepository = userClientRepository;
  }

  public UserEmployee addEmployee(UserEmployeeDTO userEmployeeDTO) {
    MovieTheatre byId = movieTheatreRepository.findById(userEmployeeDTO.getTheater_id()).orElse(new MovieTheatre());
    String username = userEmployeeDTO.getUsername();

    UserAdmin userAdmin = userAdminRepository.findByUsername(username);
    UserEmployee userEmployee = userEmployeeRepository.findByUsername(username);
    UserClient userClient = userClientRepository.findByUsername(username);

    if (userAdmin == null && userEmployee == null && userClient == null) {
      userEmployee = new UserEmployee(userEmployeeDTO, byId);
      return userEmployeeRepository.save(userEmployee);
    }
    return null;
  }

  public List<UserEmployee> getAllEmployees() {
    return userEmployeeRepository.findAll();
  }

  public UserEmployee getEmployeeById(Long id) {
    return userEmployeeRepository.findById(id).orElse(new UserEmployee());
  }

  public UserEmployee deleteEmployeeById(Long id) {
    UserEmployee userEmployee = userEmployeeRepository.findById(id).orElse(new UserEmployee());
    userEmployeeRepository.delete(userEmployee);
    return userEmployee;
  }
}
