package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.MovieTheatre;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.repository.MovieTheatreRepository;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserEmployeeService {

  UserEmployeeRepository userEmployeeRepository;
  MovieTheatreRepository movieTheatreRepository;

  @Autowired
  public UserEmployeeService(UserEmployeeRepository userEmployeeRepository, MovieTheatreRepository movieTheatreRepository) {
    this.userEmployeeRepository = userEmployeeRepository;
    this.movieTheatreRepository = movieTheatreRepository;
  }

  public UserEmployee addEmployee(UserEmployeeDTO userEmployeeDTO) {
    MovieTheatre byId = movieTheatreRepository.findById(userEmployeeDTO.getTheater_id()).orElse(new MovieTheatre());
    UserEmployee userEmployee = new UserEmployee(userEmployeeDTO, byId);
    return userEmployeeRepository.save(userEmployee);
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
