package com.example.basic.deliveryServiceApi.service;

import com.example.basic.deliveryServiceApi.dto.OrderDto;
import com.example.basic.deliveryServiceApi.dto.OrderRequestDto;
import com.example.basic.deliveryServiceApi.model.Restaurant;
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

    // 주문 요청하기
    @Transactional
    public OrderRequestDto addOrders(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("음식점이 존재하지 않습니다."));

        // 내일하자!!!

        return orderRequestDto;
    }

    // 주문 조회
    public List<OrderDto> findOrdersList() {
        List<OrderDto> orderDtoList = new ArrayList<>();

        // 내일하자!!!

        return orderDtoList;
    }
}
