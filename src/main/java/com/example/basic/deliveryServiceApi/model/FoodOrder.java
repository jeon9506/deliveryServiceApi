package com.example.basic.deliveryServiceApi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "food_order")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //음식점_ID


    @Column(name = "total_price", nullable = false)
    private Long totalPrice; // 주문음식의 총 가격

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "foodorder")//mappedBy는 카멜케이스
    private List<FoodOrderDetails> foodOrderDetails = new ArrayList<>();
}
