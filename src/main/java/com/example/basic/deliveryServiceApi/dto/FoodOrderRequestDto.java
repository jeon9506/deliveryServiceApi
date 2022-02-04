package com.example.basic.deliveryServiceApi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * - 음식 주문 정보 (foods)
 * 1. 음식 ID (id)
 * 2. 음식을 주문할 수량 (quantity)
 */
@Getter
@Setter
public class FoodOrderRequestDto {
    private Long id;        // 음식 ID (id)
    private int quantity;   // 음식을 주문할 수량 (quantity)
}
