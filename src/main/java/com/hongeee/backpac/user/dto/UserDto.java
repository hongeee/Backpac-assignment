package com.hongeee.backpac.user.dto;

import com.hongeee.backpac.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    private String email;

    private String username;

    private String nickname;

    private String password;

    private String phoneNumber;

    private String gender;

    @Builder
    public UserDto(String email, String username, String nickname, String password, String phoneNumber, String gender) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .nickname(nickname)
                .password(password)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
    }
}
