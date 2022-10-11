package com.hod0ri.board.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityService {
    // Test data (원래 이러면 혼남)
    private static final String SECRET_KEY = "SECRET_SAMPLE_KEY_THIS_IS_NOT_REAL_PROJECT_JUST_STUDY";

    public String createToken(String subject, long expiration) {
        if(expiration <= 0) {
            throw new RuntimeException("Invalid expiration");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject)  // User ID
                .signWith(signingKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // expiration
                .compact();
    }

    public String getSubject(String token) {
        Claims claim = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claim.getSubject();
    }
}
