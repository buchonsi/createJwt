package me.yoon.createtoken.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {

    private String userId;
    private String userPw;

    public UserInfo() {
    }

    public UserInfo(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

    public static UserInfo of() {
        return new UserInfo("userId", "userPw");
    }

    public static UserInfo of(String userId, String userPw) {
        return new UserInfo(userId, userPw);
    }

}
