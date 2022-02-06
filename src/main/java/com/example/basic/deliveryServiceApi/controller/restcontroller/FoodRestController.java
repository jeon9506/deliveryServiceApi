package com.example.basic.deliveryServiceApi.controller.restcontroller;

import com.example.basic.deliveryServiceApi.dto.request.FoodRequestDto;
import com.example.basic.deliveryServiceApi.dto.response.FoodResponseDto;
import com.example.basic.deliveryServiceApi.service.FoodService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class FoodRestController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    @ApiOperation(value = "음식 등록", notes = "해당 음식적의 음식 여러개 등록")
    @ApiImplicitParam(name = "restaurantId", value = "음식점 아이디", paramType = "path")
    public ResponseEntity<Object> addFoodList(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDtoList) {

        foodService.addFoodList(requestDtoList, restaurantId);

        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    @ApiOperation(value = "음식 조회", notes = "해당 음식점의 모든 음식 조회")
    @ApiImplicitParam(name = "restaurantId", value = "음식점 아이디", paramType = "path")
    public List<FoodResponseDto> findRestaurantFoodList(@PathVariable Long restaurantId) {
        return foodService.findRestaurantFoodList(restaurantId);
    }
}