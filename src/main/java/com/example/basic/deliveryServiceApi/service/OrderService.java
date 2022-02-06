package com.example.basic.deliveryServiceApi.service;

import com.example.basic.deliveryServiceApi.dto.request.FoodOrderRequestDto;
import com.example.basic.deliveryServiceApi.dto.request.OrderRequestDto;
import com.example.basic.deliveryServiceApi.dto.response.FoodOrderResponseDto;
import com.example.basic.deliveryServiceApi.dto.response.OrderResponseDto;
import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Orders;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import com.example.basic.deliveryServiceApi.repository.FoodRepository;
import com.example.basic.deliveryServiceApi.repository.OrderItemRepository;
import com.example.basic.deliveryServiceApi.repository.OrderRepository;
import com.example.basic.deliveryServiceApi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    // 주문 요청하기
    @Transactional
    public void addOrders(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("해당 음식점이 없습니다."));
        List<FoodOrderRequestDto> foodOrderRequestDtos = orderRequestDto.getFoods();
        List<FoodOrderResponseDto> foods = new ArrayList<>();

        int totalPrice = 0;
        int index = 0;

        for (FoodOrderRequestDto foodOrderRequestDto : foodOrderRequestDtos) {
            Long foodId = foodOrderRequestDto.getId();
            int quantity = foodOrderRequestDto.getQuantity();

            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("음식 주문 수량은 1 ~ 100사이 입니다.");
            }

            Food food = foodRepository.findById(foodId).orElseThrow(() -> new NullPointerException("해당 음식이 없습니다."));
            totalPrice += food.getPrice(); // 총금액
        }
        if (totalPrice < restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("주문 음식점의 최소 주문 가격을 넘지 않았습니다!!!");
        }

        // 주문 마스터
        Orders orders = Orders.builder()
                .restaurant(restaurant)
                .totalPrice(totalPrice).build();


        // Orders 주문 마스터 생성!!!
        orderRepository.save(orders);




//
//        OrderResponseDto orderResponseDto = new OrderResponseDto(orders, foodOrderRequestDtos, restaurant.getDeliveryFee());
//
//
//        OrdersItem ordersItem = OrdersItem.builder()
//                .quantity(quantity)
//                .price(food.getPrice() * quantity)
//                .food(food)
//                .build();
//
//        // Orders 주문상세 생성!!!
//        orderItemRepository.save(ordersItem);

//        return orderResponseDto;
    }

    // 주문 조회
    public List<OrderResponseDto> findOrdersList() {
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        // 내일하자!!!

        return orderResponseDtos;
    }
}
