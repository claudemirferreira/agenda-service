package com.springjwt.controllers;

import com.springjwt.dto.AuthenticationDTO;
import com.springjwt.dto.AuthenticationResponse;
import com.springjwt.services.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody @Validated AuthenticationDTO authenticationDTO,
                                                                                   HttpServletResponse response)
            throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            log.info("call createAuthenticationToken {}", authenticationDTO);
            return authService.createAuthenticationToken(authenticationDTO);
        } catch (BadCredentialsException e) {
            log.error("Incorrect username or password! {}", e.getMessage());
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException) {
            log.error("User is not activated {}", disabledException.getMessage());
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }

    }

}
