package me.yoon.createtoken.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = JwtService.class)
class JwtServiceTest {

    private final JwtService jwtService;

    public JwtServiceTest(@Autowired JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Test
    void jwt생성() {
        jwtService.createJwt("userTest");
    }

}