package me.yoon.createtoken.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {

    private final SecretKey secretKey = Jwts.SIG.HS512.key().build();

    private String makeSecretKey(String userId) {
        SecretKey secretKey = Jwts.SIG.HS512.key().build();
        String encodeSecretKey = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(encodeSecretKey);
        return null;

    }

    public String createJwt(String userId) {
        log.info("[secret key] ===> {}", secretKey.getEncoded());

        Date now = new Date();
        return Jwts.builder()
                .issuer("yoon")
                .subject("AccessToken")
                .claim("user_id", userId)
                .expiration(new Date(now.getTime() + 10000000))
                .signWith(secretKey)
                .compact();
    }

    public String getAccessUserId(String jwt) {
        Jws<Claims> claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(jwt);

        log.info("[claims keySet] ===> {}", claims.getPayload().keySet());
        log.info("[claims keySet] ===> {}", claims.getPayload().values());

        return claims.getPayload().get("user_id").toString();
    }

}
