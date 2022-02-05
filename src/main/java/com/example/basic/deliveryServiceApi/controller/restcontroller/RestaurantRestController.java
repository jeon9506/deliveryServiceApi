package com.example.basic.deliveryServiceApi.controller.restcontroller;

import com.example.basic.deliveryServiceApi.dto.RestaurantDto;
import com.example.basic.deliveryServiceApi.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    @ApiOperation(value = "음식점 등록", notes = "음식점을 등록한다.")
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto requestDto) {
        return restaurantService.addRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    @ApiOperation(value = "음식점 조회", notes = "음식점 전체를 조회한다.")
    public List<RestaurantDto> findRestaurantList() {
        return restaurantService.findRestaurantList();
    }
}


