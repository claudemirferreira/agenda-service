package com.setebit.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptService {

    public String encrypter(String value){
        return new BCryptPasswordEncoder().encode(value);
    }

}
