package com.example.springboot.controller;

import com.example.springboot.model.AuthenticationRequest;
import com.example.springboot.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authenticate")
@Tag(name = "Authentication", description = "Operations related to authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(description = "Authenticate a operator")
    @PostMapping
    public String authenticate(@RequestBody AuthenticationRequest authenticationRequest ) {
        return authenticationService.authenticate(authenticationRequest);
    }
}
