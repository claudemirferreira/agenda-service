package com.setebit.services;

import com.setebit.dto.CreateUserDTO;
import com.setebit.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(CreateUserDTO createUserDTO);

    public UserDTO findFirstByLogin(String login);

    List<UserDTO> findAll();

}
