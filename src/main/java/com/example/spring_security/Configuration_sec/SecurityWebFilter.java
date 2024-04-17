package com.example.spring_security.Configuration_sec;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityWebFilter extends OncePerRequestFilter {

    @Autowired
    UserDetailsService usersDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer "))

            {
            filterChain.doFilter(request, response);
            return;
        }

            try {
                System.err.println("1:"+token);
                if (token != null && token.startsWith("Bearer ")) {
                    token = token.substring(7); // Remove "Bearer " prefix
                    System.err.println("2: " + token);

                }
                System.out.println("00");
                String username = Jwts.parser().setSigningKey("edfsezxxe7dr").parseClaimsJws(token).getBody().getSubject();
                System.err.println("3: "+username);

                if (username != null) {
                    System.err.println("4: "+username);


                    UserDetails usersDetails =usersDetailsService.loadUserByUsername(username);
                    System.err.println(usersDetails.getPassword());
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usersDetails,null,usersDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(auth);

                    System.err.println("4: "+auth.getName());
                    System.err.println("5: "+auth.isAuthenticated());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        filterChain.doFilter(request, response);

    }
    }

