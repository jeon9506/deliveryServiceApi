package com.example.basic.deliveryServiceApi.repository;

import com.example.basic.deliveryServiceApi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
