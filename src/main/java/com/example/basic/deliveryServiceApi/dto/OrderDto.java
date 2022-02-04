package com.example.basic.deliveryServiceApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 3. 주문 요청하기
 * - 주문 요청에 대한 응답으로 다음 정보를 포함시킴
 * 1. 주문 음식점 이름 (restaurantName)
 * 2. 주문 음식 정보 (foods)
 * 3. 배달비 (deliveryFee)
 * 4. 최종 결제 금액 (totalPrice)
 */
@Getter
@Setter
public class OrderDto {
    private String restaurantName;      // 주문 음식점 이름 (restaurantName)
    private List<FoodOrderDto> foods;   // 주문 음식 정보 (foods)
    private int deliveryFee;            // 배달비
    private int totalPrice;             // 주문 음식의 가격
}
