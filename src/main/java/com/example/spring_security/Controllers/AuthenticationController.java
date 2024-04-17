package com.example.spring_security.Controllers;

import com.example.spring_security.Configuration_sec.JWTUtils;
import com.example.spring_security.Configuration_sec.UsersDetails;
import com.example.spring_security.entity.AuthenticationRequest;
import com.example.spring_security.entity.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationConfig;

    @Autowired
    JWTUtils jwtUtils;
    @PostMapping  ("/")
    @ResponseBody

    public AuthenticationResponse authenticate (@RequestBody AuthenticationRequest authenticationRequest)

    {
        System.err.println("****************");

        authenticationConfig.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        return jwtUtils.generateToken(authenticationRequest.getUsername());   }

}


