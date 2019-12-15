package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.UserAdmin;
import com.linkomanija.backend.domain.UserClient;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.LoginDTO;
import com.linkomanija.backend.dto.RegisterDTO;
import com.linkomanija.backend.dto.UserDTO;
import com.linkomanija.backend.repository.UserAdminRepository;
import com.linkomanija.backend.repository.UserClientRepository;
import com.linkomanija.backend.repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserAdminRepository userAdminRepository;
  private UserClientRepository userClientRepository;
  private UserEmployeeRepository userEmployeeRepository;

  @Autowired
  public UserService(UserAdminRepository userAdminRepository, UserClientRepository userClientRepository, UserEmployeeRepository userEmployeeRepository) {
    this.userAdminRepository = userAdminRepository;
    this.userClientRepository = userClientRepository;
    this.userEmployeeRepository = userEmployeeRepository;
  }

  public UserClient register(RegisterDTO registerDTO) {
    String username = registerDTO.getUsername();
    UserAdmin userAdmin = userAdminRepository.findByUsername(username);
    UserEmployee userEmployee = userEmployeeRepository.findByUsername(username);
    UserClient userClient = userClientRepository.findByUsername(username);

    if (userAdmin == null && userEmployee == null && userClient == null) {
      UserClient userClient1 = new UserClient(registerDTO);
      userClientRepository.save(userClient1);
      return  userClient1;
    }
    return null;
  }

  public UserDTO login(LoginDTO loginDTO) {
    boolean passwordIsCorrect = false;
    String username = loginDTO.getUsername();
    String password = loginDTO.getPassword();

    UserAdmin userAdmin = userAdminRepository.findByUsername(username);
    UserEmployee userEmployee = userEmployeeRepository.findByUsername(username);
    UserClient userClient = userClientRepository.findByUsername(username);
    UserDTO userDTO = null;

    //inheritance kur tu...
    if (userAdmin != null) {
      userDTO = new UserDTO(userAdmin, null, null, "admin");
      passwordIsCorrect = userAdmin.isPasswordCorrect(password);
    }

    if (userClient != null) {
      userDTO = new UserDTO(null, userClient, null, "client");
      passwordIsCorrect = userClient.isPasswordCorrect(password);
    }

    if (userEmployee != null) {
      userDTO = new UserDTO(null, null, userEmployee, "employee");
      passwordIsCorrect = userEmployee.isPasswordCorrect(password);
    }

    if (passwordIsCorrect)
      return userDTO;
    return null;
  }
}
