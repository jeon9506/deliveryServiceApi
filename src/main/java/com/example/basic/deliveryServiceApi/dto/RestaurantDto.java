package com.example.basic.deliveryServiceApi.dto;

import lombok.*;

@Getter
@Setter
public class RestaurantDto {
    private Long id; //음식점_ID
    private String name; //음식점 이름
    private Long minOrderPrice; // 최소주문가격
    private Long deliveryFree; // 기본배달비
}
