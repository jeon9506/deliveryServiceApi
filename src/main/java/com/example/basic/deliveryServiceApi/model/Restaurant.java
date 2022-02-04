package com.example.basic.deliveryServiceApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
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
    private Long minOrderPrice; // 최소주문가격

    @Column(name = "delivery_free", nullable = false)
    private Long deliveryFree; // 기본배달비

    @OneToMany(mappedBy = "restaurant")
    private List<FoodOrder> foodOrders = new ArrayList<>();

    @Builder // 빌더 패턴
    public Restaurant(Long id, String name, Long minOrderPrice, Long deliveryFree) {
        this.id = id;
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFree = deliveryFree;
    }


}
