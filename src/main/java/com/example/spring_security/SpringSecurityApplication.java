package com.example.spring_security;

import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.Users;
import com.example.spring_security.services.RoleService;
import com.example.spring_security.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class SpringSecurityApplication {
    @Autowired
    userService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoderBean;

    @PostConstruct
    public void addUser ()
    {
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");

        roleService.addRole(role1);
        roleService.addRole(role2);




        Users users = new Users("issam",passwordEncoderBean.encode("pwd1"));
        users.addRole(role1);
        users.addRole(role2);

        Users users1 = new Users("flenn",passwordEncoderBean.encode("pwd2"));
        users1.addRole(role2);

        Users users2 = new Users("hama",passwordEncoderBean.encode("pwd3"));
        users2.addRole(role2);

        userService.addUser(users);
        userService.addUser(users1);
        userService.addUser(users2);

    }


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);



    }

}
