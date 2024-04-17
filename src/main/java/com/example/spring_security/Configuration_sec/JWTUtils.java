package com.example.spring_security.Configuration_sec;

import com.example.spring_security.entity.AuthenticationResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
public class JWTUtils {
    private static final String SECRET_KEY= "edfsezxxe7dr";
    Date expirationDate = new Date(System.currentTimeMillis() + 86400000); // Expiration dans 24 heures

    public AuthenticationResponse generateToken(String userName) {
       String token= String.valueOf(Jwts.builder().setSubject(userName)
                .setIssuer(userName)
                .setIssuedAt(new Date())
               .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact());
        return  new AuthenticationResponse(token);
    }
}
