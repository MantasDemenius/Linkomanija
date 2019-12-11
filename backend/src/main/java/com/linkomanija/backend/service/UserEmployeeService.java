package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.repository.UserEmployeeRepository;
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
}
