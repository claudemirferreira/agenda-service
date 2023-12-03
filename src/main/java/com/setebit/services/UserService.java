package com.setebit.services;

import com.setebit.dto.CreateUserDTO;
import com.setebit.dto.UserDTO;
import com.setebit.dto.UserPasswordDTO;
import com.setebit.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    UserDTO create(CreateUserDTO createUserDTO);

    UserDTO updatePassword(UserPasswordDTO dto) throws ResourceNotFoundException;

    public UserDTO findFirstByLogin(String login);

    List<UserDTO> findAll();

}
