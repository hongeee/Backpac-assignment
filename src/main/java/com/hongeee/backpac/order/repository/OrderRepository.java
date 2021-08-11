package com.hongeee.backpac.order.repository;

import com.hongeee.backpac.order.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, String> {

}
