package com.hongeee.backpac.order.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Builder
    public UserOrder(String orderNumber, String productNumber, Timestamp paymentDate) {
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.paymentDate = paymentDate;
    }
}
