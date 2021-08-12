package com.hongeee.backpac.user.entity;

import com.hongeee.backpac.order.entity.UserOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "email")
    private List<UserOrder> userOrders = new ArrayList<>();

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

    public void addUserOrder(UserOrder userOrder) {
        userOrders.add(userOrder);
        userOrder.setUser(this);
    }
}

