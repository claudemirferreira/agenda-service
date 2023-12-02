package com.springjwt.services;

import com.springjwt.dto.CreateUserDTO;
import com.springjwt.dto.UserDTO;

public interface UserService {
    UserDTO create(CreateUserDTO createUserDTO);

    public UserDTO findFirstByLogin(String login);

}
