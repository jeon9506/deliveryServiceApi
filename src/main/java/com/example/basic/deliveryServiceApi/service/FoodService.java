package com.example.basic.deliveryServiceApi.service;


import com.example.basic.deliveryServiceApi.dto.FoodDto;
import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Restaurant;
import com.example.basic.deliveryServiceApi.repository.FoodRepository;
import com.example.basic.deliveryServiceApi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    // 음식점에 음식 여러개 등록
    @Transactional
    public void addFoodList(List<FoodDto> requestDtoList, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 존재하지 않습니다."));

        requestDtoList.stream().forEach(foodDto -> {
            int price = foodDto.getPrice();
            if (price < 100) {
                throw new IllegalArgumentException("음식 가격이 100원 미만입니다.");
            }

            if (price > 1_000_000) {
                throw new IllegalArgumentException("음식 가격이 1,000,000원을 초과했습니다.");
            }

            if (price % 100 > 0) {
                throw new IllegalArgumentException("음식 가격이 100원 단위로 입력되었습니다.");
            }

            Optional<Food> found = foodRepository.findFoodByRestaurantAndName(restaurant, foodDto.getName());
            if(found.isPresent()){
                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
            }

            foodDto.setRestaurantId(restaurantId);
            foodRepository.save(foodDto.toEntity(restaurant));
        });
    }

    // 음식점의 음식 조회
    public List<FoodDto> findRestaurantFoodList(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("해당 음식점이 존재하지 않습니다."));

        return foodRepository.findAllByRestaurantId(restaurant.getId()).stream().map(food -> food.toDto())
                .collect(Collectors.toList());
    }
}
