package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEmployeeService {
  private UserEmployeeRepository userEmployeeRepository;

  @Autowired
  public UserEmployeeService(UserEmployeeRepository userEmployeeRepository) {
    this.userEmployeeRepository = userEmployeeRepository;
  }

  public UserEmployee save(UserEmployee userEmployee) {
    return userEmployeeRepository.save(userEmployee);
  }

  public UserEmployee getEmployee(Long id) {
    return userEmployeeRepository.findById(id).orElse(null);
  }
}
