package com.example.basic.deliveryServiceApi.service;

import com.example.basic.deliveryServiceApi.dto.request.FoodOrderRequestDto;
import com.example.basic.deliveryServiceApi.dto.request.OrderRequestDto;
import com.example.basic.deliveryServiceApi.dto.response.FoodResponseDto;
import com.example.basic.deliveryServiceApi.dto.response.OrderResponseDto;
import com.example.basic.deliveryServiceApi.model.Food;
import com.example.basic.deliveryServiceApi.model.Orders;
import com.example.basic.deliveryServiceApi.model.OrdersItem;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    // 주문 요청하기
    @Transactional
    public OrderResponseDto addOrders(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("해당 음식점이 없습니다."));

        List<FoodOrderRequestDto> foodOrderRequestDtos = orderRequestDto.getFoods();
        List<OrdersItem> ordersItems = new ArrayList<>();
        List<FoodResponseDto> foodResponseDtos = new ArrayList<>();
        int totalPrice = 0;

        for (FoodOrderRequestDto foodOrderRequestDto : foodOrderRequestDtos) {
            Long foodId = foodOrderRequestDto.getId();
            int quantity = foodOrderRequestDto.getQuantity();

            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("음식 주문 수량은 1 ~ 100사이 입니다.");
            }

            Food food = foodRepository.findById(foodId).orElseThrow(() -> new NullPointerException("해당 음식이 없습니다."));
            int foodPrice = food.getPrice() * quantity;

            OrdersItem ordersItem = OrdersItem.builder()
                    .quantity(quantity)
                    .price(foodPrice)
                    .food(food)
                    .build();

            ordersItems.add(ordersItem);

            // OrdersItem에는 food_name이 없다
            FoodResponseDto foodsResponseDto = ordersItem.toDto();
            foodsResponseDto.setPrice(foodPrice); // 수량을 곱한 가격을 set해줌
            foodResponseDtos.add(foodsResponseDto);

            totalPrice += foodPrice; // 음식 총 금액
        }

        if (totalPrice < restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("주문 음식점의 최소 주문 가격을 넘지 않았습니다!!!");
        }

        totalPrice += restaurant.getDeliveryFee(); // 음식점 배달비 추가

        // 주문 마스터
        Orders orders = Orders.builder()
                .restaurant(restaurant)
                .totalPrice(totalPrice).build();

        // Orders 주문 마스터 생성!!!
        orderRepository.save(orders);
        for (OrdersItem ordersItem : ordersItems) {
            OrdersItem tempOrders = OrdersItem.builder()
                    .orders(orders)
                    .quantity(ordersItem.getQuantity())
                    .price(ordersItem.getPrice())
                    .food(ordersItem.getFood())
                    .build();

            // Orders 주문상세 생성!!!
            orderItemRepository.save(tempOrders);
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto(orders, foodResponseDtos);

        return orderResponseDto;
    }

    // 주문 조회
    public List<OrderResponseDto> findOrdersList() {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        // 주문내역
        List<Orders> ordersList = orderRepository.findAll();

        // 주문상세내역
        for (Orders orders : ordersList) {
//            Optional<Restaurant> restaurant = restaurantRepository.findById(orders.getRestaurant().getId());
            // 주문한 품목
            List<OrdersItem> ordersItemList = orderItemRepository.findOrdersItemByOrders(orders);
            List<FoodResponseDto> foodResponseDtoList = new ArrayList<>();// foodDto 담을 그릇
            for (OrdersItem ordersItem : ordersItemList) {
                FoodResponseDto foodResponseDto = FoodResponseDto.builder()
                        .id(ordersItem.getId())
                        .name(ordersItem.getFood().getName())
                        .price(ordersItem.getPrice())
                        .build();
                foodResponseDtoList.add(foodResponseDto);
            }

            OrderResponseDto orderResponseDto = new OrderResponseDto(orders, foodResponseDtoList);
            orderResponseDtoList.add(orderResponseDto);
        }

        return orderResponseDtoList;
    }
}