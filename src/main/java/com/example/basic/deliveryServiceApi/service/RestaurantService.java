package com.example.basic.deliveryServiceApi.service;

import com.example.basic.deliveryServiceApi.dto.RestaurantDto;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import com.example.basic.deliveryServiceApi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // 음식점 정보 입력받아 등록
    @Transactional
    public RestaurantDto addRestaurant(RestaurantDto requestDto) {
        Restaurant restaurant = requestDto.toEntity();

        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();
        if(!(1000 <= minOrderPrice && minOrderPrice <= 100000)) {
            throw new IllegalArgumentException("최소주문 가격 허용값을 벗어났습니다.");
        }

        if(minOrderPrice % 100 > 0) {
            throw new IllegalArgumentException("100원 단위로 입력하지 않았습니다.");
        }

        if(0 > deliveryFee || deliveryFee > 10_000) {
            throw new IllegalArgumentException("기본 배달비 허용값을 벗어났습니다.");
        }

        if(deliveryFee % 500 > 0) {
            throw new IllegalArgumentException("기본 배달비 500원 단위로 입력하지 않았습니다.");
        }

        return restaurantRepository.save(restaurant).toDto();
    }

    // 음식점 전체 조회
    public List<RestaurantDto> findRestaurantList() {
        return restaurantRepository.findAll().stream().map(restaurant -> restaurant.toDto()).collect(Collectors.toList());
    }
}
