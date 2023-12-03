package com.setebit.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsAuthentication extends UserDetails {
    String getName();
    String getEmail();
    Integer getId();


}
