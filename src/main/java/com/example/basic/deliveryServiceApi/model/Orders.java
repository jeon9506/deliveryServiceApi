package com.example.basic.deliveryServiceApi.model;

import com.example.basic.deliveryServiceApi.dto.response.FoodResponseDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // DB 테이블 역할을 합니다.
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 주문 ID(orders_id)


    @Column(name = "total_price", nullable = false)
    private int totalPrice; // 주문음식의 총 가격(total_price)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant; // 음식적 ID(restaurant_id)

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)// orders를 생성할떄 자동으로 ordersItems를 생성한다.
    private List<OrdersItem> ordersItems = new ArrayList<>();
}
