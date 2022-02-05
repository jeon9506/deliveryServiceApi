package com.example.basic.deliveryServiceApi.dto;

import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import lombok.*;

/**
 * 2. 음식 등록
 * - 음식점 ID 및 음식 정보 입력받아 등록
 * 1. 음식점 ID (restaurantId)
 * 2. 음식명 (name)
 * 3. 가격 (price)
 */
@Getter
@Setter
@Builder
public class FoodDto {
    private Long restaurantId;      // 음식점 ID (restaurantId)
    private Long id;                // 음식 ID (id)
    private String name;            // 음식명 (name)
    private int price;              // 가격 (price)

    public Food toEntity(Restaurant restaurant) {
        return Food.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .restaurant(restaurant)
                .build();
    }
}