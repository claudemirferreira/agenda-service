package com.setebit.services.auth;

import com.setebit.dto.AuthenticationDTO;
import com.setebit.dto.AuthenticationResponse;
import com.setebit.services.jwt.UserDetailsServiceImpl;
import com.setebit.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationDTO authenticationDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getLogin(), authenticationDTO.getPassword()));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getLogin());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return AuthenticationResponse.builder().jwtToken(jwt).login(userDetails.getUsername()).build();

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException) {
            throw new DisabledException("User is not activated!");
        }
    }
}
