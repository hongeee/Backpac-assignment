package com.hongeee.backpac.order.controller;

import com.hongeee.backpac.order.dto.UserOrderDto;
import com.hongeee.backpac.order.entity.UserOrder;
import com.hongeee.backpac.order.service.UserOrderService;
import com.hongeee.backpac.user.entity.User;
import com.hongeee.backpac.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Locale;

@RestController
@RequestMapping("/api/orders")
public class UserOrderApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrderService userOrderService;

    /**
     * 회원 계정으로 제품을 주문한다.
     *
     * @param userOrderDto 제품명
     * @param email 회원 계정 이메일
     * @return 주문 완료된 정보
     */
    @PostMapping
    public UserOrder addOrder(@RequestBody UserOrderDto userOrderDto, @RequestParam String email) {
        // TODO: 로그인 기능 구현 후 세션 정보를 통해 회원 정보를 조회하도록 변경하고 email parameter 제거 필요함
        User user = userService.getUserAccount(email);

        if (user == null) {
            // 존재하지 않는 계정일 경우 주문 불가
            return null;
        }

        UserOrder userOrder = UserOrder.builder()
                .orderNumber(RandomStringUtils.randomAlphanumeric(12).toUpperCase())
                .productNumber(userOrderDto.getProductNumber())
                .paymentDate(new Timestamp(System.currentTimeMillis()))
                .build();

        user.addUserOrder(userOrder);

        return userOrderService.createUserOrder(userOrder);
    }
}
