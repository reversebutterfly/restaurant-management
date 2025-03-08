package com.restaurant.controller;

import com.restaurant.entity.Business;
import com.restaurant.service.BusinessService;
import com.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping("/login")
    public ApiResponse<Business> login(@RequestBody Business loginRequest) {
        Business business = businessService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (business != null) {
            return ApiResponse.success("登录成功", business);
        } else {
            return ApiResponse.error("用户名或密码错误");
        }
    }
}