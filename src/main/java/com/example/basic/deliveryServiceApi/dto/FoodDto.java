package com.example.basic.deliveryServiceApi.dto;

import lombok.*;

@Getter
@Setter
public class FoodDto {
    private Long id; // 음식 ID
    private String name; // 음식 이름
    private Long price; // 음식 가격
}
