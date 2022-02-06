package com.example.basic.deliveryServiceApi.model;

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
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 주문 ID(orders_id)


    @Column(name = "total_price", nullable = false)
    private int totalPrice; // 주문음식의 총 가격(total_price)

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant; // 음식적 ID(restaurant_id)

    @OneToMany(mappedBy = "orders")//mappedBy는 카멜케이스
    private List<OrdersItem> ordersItems = new ArrayList<>();
}
