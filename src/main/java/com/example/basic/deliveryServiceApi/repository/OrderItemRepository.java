package com.example.basic.deliveryServiceApi.repository;

import com.example.basic.deliveryServiceApi.model.Orders;
import com.example.basic.deliveryServiceApi.model.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrdersItem, Long> {
    List<OrdersItem> findOrdersItemByOrders(Orders orders);
}
