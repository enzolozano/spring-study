package com.example.springboot.security;

import com.example.springboot.exception.model.UnauthorizedException;
import com.example.springboot.model.AuthenticationRequest;
import com.example.springboot.model.CustomAuthenticationRequest;
import com.example.springboot.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private JwtService jwtService;

    public String authenticate(AuthenticationRequest authenticationRequest) {

        if (!operatorService.operatorExists(authenticationRequest.getUsername(), authenticationRequest.getPassword())) {
            throw new UnauthorizedException("No user found with the credentials");
        }

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        Authentication authentication = new CustomAuthenticationRequest(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword(),
                authorities
        );

        return jwtService.generateToken(authentication);
    }
}
