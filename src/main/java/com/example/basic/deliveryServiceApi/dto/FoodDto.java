package com.example.basic.deliveryServiceApi.dto;

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
public class FoodDto {
    private Long id;        // 음식점 ID (restaurantId)
    private String name;    // 음식명 (name)
    private int price;      // 가격 (price)
}