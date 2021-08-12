package com.hongeee.backpac.order.service;

import com.hongeee.backpac.order.entity.UserOrder;
import com.hongeee.backpac.order.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public UserOrder createUserOrder(UserOrder userOrder) {
        return userOrderRepository.save(userOrder);
    }
}
