package com.example.basic.deliveryServiceApi.repository;

import com.example.basic.deliveryServiceApi.model.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrdersItem, Long> {

}
