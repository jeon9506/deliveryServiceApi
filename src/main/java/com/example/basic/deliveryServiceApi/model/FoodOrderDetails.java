package com.example.basic.deliveryServiceApi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "food_order_details")
public class FoodOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //음식점_ID

    @Column(name = "quantity", nullable = false)
    private int quantity; // 주문수량

    @Column(name = "price", nullable = false)
    private Long price; // 주문음식의 가격

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private FoodOrderDetails foodorder;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}
