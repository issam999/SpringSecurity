package com.example.spring_security.Controllers;


import com.example.spring_security.Configuration_sec.JWTUtils;
import com.example.spring_security.Repos.Repo_User;
import com.example.spring_security.entity.AuthenticationRequest;
import com.example.spring_security.entity.AuthenticationResponse;
import com.example.spring_security.entity.Users;
import com.example.spring_security.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    userService userservice;

    @Autowired
    Repo_User repoUser;


    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userservice.getAllUser();
    }

    @GetMapping("/{username}")
    public Users getUser(@PathVariable String username) {
        return repoUser.findUsersByName(username);
    }


}