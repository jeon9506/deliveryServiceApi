package com.example.basic.deliveryServiceApi.dto.response;

import com.example.basic.deliveryServiceApi.model.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 1. 음식점 조회
 * - 음식점 ID (id)
 * - 음식점 이름 (name)
 * - 최소주문 가격 (minOrderPrice)
 * - 기본 배달비 (deliveryFee)
 */
@Getter
@Setter
@Builder
public class RestaurantResponseDto {
    private Long id;            // 음식점 ID (id)
    private String name;        // 음식점 이름 (name)
    private int minOrderPrice;  // 최소주문 가격 (minOrderPrice)
    private int deliveryFee;    // 기본 배달비 (deliveryFee)

    public Restaurant toEntity() {
        return Restaurant.builder()
                .id(this.id)
                .name(this.name)
                .minOrderPrice(this.minOrderPrice)
                .deliveryFee(this.deliveryFee)
                .build();
    }
}