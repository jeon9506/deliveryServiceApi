package com.example.basic.deliveryServiceApi.model;

import com.example.basic.deliveryServiceApi.dto.RestaurantDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //음식점_ID

    @Column(name = "restaurant_name", nullable = false)
    private String name; //음식점 이름

    @Column(name = "min_order_price", nullable = false)
    private int minOrderPrice; // 최소주문가격

    @Column(name = "delivery_fee", nullable = false)
    private int deliveryFee; // 기본배달비

    @OneToMany(mappedBy = "restaurant")
    private List<Orders> Orders = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Food> foods = new ArrayList<>();

    public RestaurantDto toDto() {
        return RestaurantDto.builder()
                .id(this.id)
                .name(this.name)
                .minOrderPrice(this.minOrderPrice)
                .deliveryFee(this.deliveryFee)
                .build();
    }

//    public Restaurant toDto(List<Food> foods){
//        return Restaurant.builder()
//                .foods(foods)
//                .id(this.id)
//                .build();
//    }

    public Restaurant(Long id, String name, int minOrderPrice, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}