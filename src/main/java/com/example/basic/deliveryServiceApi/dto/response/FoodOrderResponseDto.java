package com.example.basic.deliveryServiceApi.dto.response;

import lombok.*;

/**
 * - 주문 음식 정보 (foods)
 * 1. 주문 음식명 (name)
 * 2. 주문 수량 (quantity)
 * 3. 주문 음식의 가격 (price)
 */
@Getter
@Setter
public class FoodOrderResponseDto {
    private String name;        // 주문 음식명 (name)
    private int quantity;       // 주문 수량 (quantity)
    private int price;          // 주문 음식의 가격 (price)
}
