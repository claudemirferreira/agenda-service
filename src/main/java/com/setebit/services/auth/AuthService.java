package com.setebit.services.auth;

import com.setebit.dto.AuthenticationDTO;
import com.setebit.dto.AuthenticationResponse;

public interface AuthService {

    AuthenticationResponse createAuthenticationToken( AuthenticationDTO authenticationDTO);

}
