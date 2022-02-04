package com.example.basic.deliveryServiceApi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 1. 음식점 등록 및 조회
 * - 음식점 정보 입력받아 등록
 * 1. 음식점 이름 (name)
 * 2. 음식점 이름 (name)
 * 3. 최소주문 가격 (minOrderPrice)
 * 4. 기본 배달비 (deliveryFee)
 */
@Getter
@Setter
public class RestaurantDto {
    private Long id;            // 음식점 ID (id)
    private String name;        // 음식점 이름 (name)
    private int minOrderPrice;  // 최소주문 가격 (minOrderPrice)
    private int deliveryFee;    // 기본 배달비 (deliveryFee)
}