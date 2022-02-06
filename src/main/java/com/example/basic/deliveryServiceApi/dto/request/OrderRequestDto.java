package com.example.basic.deliveryServiceApi.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 3.주문 요청하기
 * - 주문 요청 시 배달 음식점 및 음식 정보 입력받음
 * 1. 음식점 ID (restaurantId)
 * 2. 음식 주문 정보 (foods)
 */
@Getter
@Setter
@Builder
public class OrderRequestDto {
    private Long restaurantId;                  // 음식점 ID (restaurantId)
    private List<FoodOrderRequestDto> foods;    // 음식 주문 정보 (foods)
}
