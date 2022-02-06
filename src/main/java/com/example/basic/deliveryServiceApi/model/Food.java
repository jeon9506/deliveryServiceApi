package com.example.basic.deliveryServiceApi.model;

import com.example.basic.deliveryServiceApi.dto.request.FoodRequestDto;
import com.example.basic.deliveryServiceApi.dto.response.FoodResponseDto;
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
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 음식 ID

    @Column(name = "name", nullable = false)
    private String name; // 음식 이름

    @Column(name = "price", nullable = false)
    private int price; // 음식 가격

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "food")//mappedBy는 카멜케이스
    private List<OrdersItem> ordersItems = new ArrayList<>();

//    public FoodRequestDto foodRequestDto() {
//        return FoodRequestDto.builder()
//                .name(this.name)
//                .price(this.price)
//                .build();
//    }

    public FoodResponseDto toFoodResponseDto() {
        return FoodResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
