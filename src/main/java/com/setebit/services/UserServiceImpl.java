package com.setebit.services;

import com.setebit.convert.UserConvertService;
import com.setebit.dto.CreateUserDTO;
import com.setebit.dto.UserDTO;
import com.setebit.entities.User;
import com.setebit.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertService userConvertService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO create(CreateUserDTO dto) {
        log.info("{}", dto);
        User user = userConvertService.convertToEntity(dto);
        log.info("{}", user);
        User entity = userRepository.save(user);
        return userConvertService.convertToDto(entity);
    }

    public UserDTO findFirstByLogin(String login) {
        User entity = userRepository.findFirstByLogin(login);
        return userConvertService.convertToDto(entity);

    }
    public List<UserDTO> findAll() {
        log.info("call findAll");
        List<User> list = userRepository.findAll();
        List<UserDTO> dtos = list.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        log.info("call findAll {}", dtos);
        return dtos;

    }
}
