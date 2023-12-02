package com.springjwt.services.auth;

import com.springjwt.dto.CreateUserDTO;
import com.springjwt.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(CreateUserDTO signupDTO);
}
