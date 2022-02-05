package com.example.basic.deliveryServiceApi.repository;

import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantId(Long restaurantId);

    Optional<Food> findFoodByRestaurantAndName(Restaurant restaurant, String foodName);
}
