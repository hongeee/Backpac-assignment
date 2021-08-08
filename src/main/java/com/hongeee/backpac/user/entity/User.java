package com.hongeee.backpac.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String email;

    private String username;

    private String nickname;

    private String password;

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

