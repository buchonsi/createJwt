package me.yoon.createtoken.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.yoon.createtoken.dto.UserInfo;
import me.yoon.createtoken.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody UserInfo userInfo) {
        //토큰 생성
        System.out.println(userInfo.toString());

        //헤더 리턴
        response.setHeader("Authorization", jwtService.createJwt(userInfo.getUserId()));

    }

    @GetMapping("/get/accessInfo")
    public String getAccessInfo(HttpServletRequest request) {
        String AccessToken = request.getHeader("Authorization");

        return jwtService.getAccessUserId(AccessToken);
    }
}
