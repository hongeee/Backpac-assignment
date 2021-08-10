package com.hongeee.backpac.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String email;

    @NonNull
    private String username;

    @NonNull
    private String nickname;

    @NonNull
    private String password;

    @NonNull
    private String phoneNumber;

    @Nullable
    private String gender;

    @Builder
    public User(String email, String username, String nickname, String password,
                String phoneNumber, String gender) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}

