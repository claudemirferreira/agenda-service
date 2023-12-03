package com.setebit.convert;

import com.setebit.dto.CreateUserDTO;
import com.setebit.dto.UserDTO;
import com.setebit.entities.User;
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
