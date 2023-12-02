package com.springjwt.services.auth;

import com.springjwt.dto.AuthenticationDTO;
import com.springjwt.dto.AuthenticationResponse;
import com.springjwt.dto.CreateUserDTO;
import com.springjwt.dto.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {

    AuthenticationResponse createAuthenticationToken( AuthenticationDTO authenticationDTO);

}
