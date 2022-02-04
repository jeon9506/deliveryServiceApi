package com.example.basic.deliveryServiceApi.controller.controller;

import com.example.basic.deliveryServiceApi.dto.RestaurantDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/"})
    public String home() {
        return "index";
    }
}