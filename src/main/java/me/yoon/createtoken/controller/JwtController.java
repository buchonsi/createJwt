package me.yoon.createtoken.controller;

import jakarta.servlet.http.HttpServletResponse;
import me.yoon.createtoken.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

//    //토큰 생성
//    @GetMapping("/get/token")
//    public void createToken(HttpServletResponse response) {
//        String userId = "";
//        response.setHeader("Authorization", jwtService.createJwt(userId));
//    }

}
