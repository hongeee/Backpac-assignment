package com.hongeee.backpac.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hongeee.backpac.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class UserOrder {

    @Id
    private String orderNumber;

    @NonNull
    private String productNumber;

    @NonNull
    private Timestamp paymentDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "email", insertable = false, updatable = false)
    private User user;

    @Builder
    public UserOrder(String orderNumber, String productNumber, Timestamp paymentDate, User user) {
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.paymentDate = paymentDate;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;

        if (!user.getUserOrders().contains(this)) {
            user.addUserOrder(this);
        }
    }
}
