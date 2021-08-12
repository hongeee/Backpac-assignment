package com.hongeee.backpac.order.dto;

import com.hongeee.backpac.order.entity.UserOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class UserOrderDto {

    private String orderNumber;

    private String productNumber;

    private Timestamp paymentDate;

    @Builder
    public UserOrderDto(String orderNumber, String productNumber, Timestamp paymentDate) {
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.paymentDate = paymentDate;
    }

    public UserOrder toEntity() {
        return UserOrder.builder()
                .orderNumber(orderNumber)
                .productNumber(productNumber)
                .paymentDate(paymentDate)
                .build();
    }
}
