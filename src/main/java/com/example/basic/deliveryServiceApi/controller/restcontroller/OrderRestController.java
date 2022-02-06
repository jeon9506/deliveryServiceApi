package com.example.basic.deliveryServiceApi.controller.restcontroller;

import com.example.basic.deliveryServiceApi.dto.request.OrderRequestDto;
import com.example.basic.deliveryServiceApi.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    @ApiOperation(value = "주문 요청하기", notes = "주문 요청 시 배달 음식점 및 음식 정보 입력받는다.")
    public void addOrders(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.addOrders(orderRequestDto);
//        return ;
//        return ResponseEntity.ok().body(null);
    }

//    @GetMapping("/orders")
//    @ApiOperation(value = "주문 조회", notes = "그동안 성공한 모든 주문 요청을 조회 가능하다.")
//    public List<OrderResponseDto> findOrdersList() {
//        return orderService.findOrdersList();
//    }
}