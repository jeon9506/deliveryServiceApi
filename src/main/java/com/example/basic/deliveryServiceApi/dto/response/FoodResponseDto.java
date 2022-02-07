package com.example.basic.deliveryServiceApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 2. 음식점 메뉴판 조회
 * 1. 음식 ID (id)
 * 2. 음식명 (name)
 * 3. 가격 (price)
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class FoodResponseDto {
    private Long id;                // 음식 ID (id)
    private String name;            // 음식명 (name)
    private int price;              // 가격 (price)
}