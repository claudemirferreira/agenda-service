package com.springjwt.convert;

import com.springjwt.dto.CreateUserDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserConvertService {


    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(CreateUserDTO dto) {
        User entity = modelMapper.map(dto, User.class);
        if (Objects.nonNull(dto.getPassword())) {
            entity.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        }
        return entity;
    }

    public UserDTO convertToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

}
