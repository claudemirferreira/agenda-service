package com.setebit.services.jwt;

import com.setebit.dto.AuthenticationResponse;
import com.setebit.entities.User;
import com.setebit.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        //Write Logic to get the user from the DB
        User user = userRepository.findFirstByLogin(login);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }

    public AuthenticationResponse loadUserByLogin(String login) throws UsernameNotFoundException {

        //Write Logic to get the user from the DB
        User user = userRepository.findFirstByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        // String jwtToken, String name, String email, Integer id)
        return modelMapper.map(user, AuthenticationResponse.class);
    }
}
