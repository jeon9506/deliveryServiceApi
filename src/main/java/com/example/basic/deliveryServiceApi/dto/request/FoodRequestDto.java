package com.example.basic.deliveryServiceApi.dto.request;

import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import lombok.*;

/**
 * 2. 음식 등록 및 메뉴판 조회
 * - 음식점 ID 및 음식 정보 입력받아 등록
 * 1. 음식점 ID (restaurantId)
 * 2. 음식명 (name)
 * 3. 가격 (price)
 */
@Getter
@Setter
@Builder
public class FoodRequestDto {
    private Long restaurantId;      // 음식점 ID (restaurantId)
    private String name;            // 음식명 (name)
    private int price;              // 가격 (price)

    public Food toEntity(Restaurant restaurant) {
        return Food.builder()
                .name(this.name)
                .price(this.price)
                .restaurant(restaurant)
                .build();
    }
}