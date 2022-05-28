package com.TrainTickets.config;

import com.TrainTickets.model.TrainTicket;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JwtTokenGeneratorImpl implements JwtTokenGenerator{

    @Value("${jwt.secret.key}")
    public String secretKey;

    @Override
    public Map<String, String> generateToken(TrainTicket ticket) {
        String token = Jwts.builder().setSubject(ticket.getName())
                .setIssuer("APPIssuer")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return Map.of("token",token);
    }
}
