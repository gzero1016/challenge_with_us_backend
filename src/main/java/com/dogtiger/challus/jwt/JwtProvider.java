package com.dogtiger.challus.jwt;

import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.UserMapper;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final Key key;
    private final UserMapper userMapper;

    public JwtProvider(@Value("${jwt.secret}") String secret, UserMapper userMapper) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.userMapper = userMapper;
    }

    public String generateToken(Authentication authentication) {
        String email = authentication.getName();

        Date date = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

        return Jwts.builder()
                .setSubject("AccessToken")
                .setExpiration(date)
                .claim("email", email)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}