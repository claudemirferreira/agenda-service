package com.springjwt.services;

import com.springjwt.convert.UserConvertService;
import com.springjwt.dto.CreateUserDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import com.springjwt.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertService userConvertService;

    @Override
    public UserDTO create(CreateUserDTO dto) {
        User user = userConvertService.convertToEntity(dto);
        User entity = userRepository.save(user);
        return userConvertService.convertToDto(entity);
    }

    public UserDTO findFirstByLogin(String login) {
        User entity = userRepository.findFirstByLogin(login);
        return userConvertService.convertToDto(entity);

    }
}
