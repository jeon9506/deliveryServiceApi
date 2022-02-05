package com.example.basic.deliveryServiceApi.repository;

import com.example.basic.deliveryServiceApi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
