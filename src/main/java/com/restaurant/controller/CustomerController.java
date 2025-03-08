package com.restaurant.controller;

import com.restaurant.entity.Customer;
import com.restaurant.service.CustomerService;
import com.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ApiResponse<?> add(@RequestBody Customer customer) {
        int result = customerService.add(customer);
        if (result > 0) {
            return ApiResponse.success("顾客信息添加成功", null);
        } else {
            return ApiResponse.error("顾客信息添加失败");
        }
    }

    @GetMapping("/{phoneNumber}")
    public ApiResponse<Customer> getByPhoneNumber(@PathVariable String phoneNumber) {
        Customer customer = customerService.findByPhoneNumber(phoneNumber);
        if (customer != null) {
            return ApiResponse.success(customer);
        } else {
            return ApiResponse.error("未找到该顾客信息");
        }
    }
}