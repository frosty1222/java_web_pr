package com.rungroop.web.service;

import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void saveUser(RegistrationDto registrationDto);
  UserEntity findByEmail(String email);

  UserEntity findByUsername(String username);
}
