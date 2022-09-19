package com.boot.mvc20220916.web.dto;

import com.boot.mvc20220916.domain.User;
import lombok.Data;

@Data
public class UserAddReqDto {
    private String userId;
    private String password;
    private String userName;
    private String userEmail;

    public User toEntity() {
        return User.builder()
                .user_id(userId)
                .user_password(password)
                .user_name(userName)
                .user_email(userEmail)
                .build();
    }
}
