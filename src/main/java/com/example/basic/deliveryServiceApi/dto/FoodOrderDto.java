package com.example.basic.deliveryServiceApi.dto;

import lombok.*;

@Getter
@Setter
public class FoodOrderDto {
    private Long id; //음식점_ID
    private Long totalPrice; // 주문음식의 총 가격
}
