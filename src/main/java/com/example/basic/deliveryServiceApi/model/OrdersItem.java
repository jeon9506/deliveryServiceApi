package com.example.basic.deliveryServiceApi.model;

import com.example.basic.deliveryServiceApi.dto.response.FoodResponseDto;
import lombok.*;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "orders_item")
public class OrdersItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //주문상세_ID

    @Column(name = "quantity", nullable = false)
    private int quantity; // 주문수량

    @Column(name = "price", nullable = false)
    private int price; // 주문음식의 가격

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    public FoodResponseDto toDto() {
        return FoodResponseDto.builder()
                .id(food.getId())
                .name(food.getName())
                .build();
    }

//    @Builder
//    public OrdersItem(int quantity, int price, Food food){
//        this.quantity = quantity;
//        this.price = price;
//        this.food = food;
//    }
}