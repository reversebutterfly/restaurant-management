package com.restaurant.controller;

import com.restaurant.entity.Order;
import com.restaurant.service.OrderMealService;
import com.restaurant.service.OrderService;
import com.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMealService orderMealService;

    @Autowired
    public OrderController(OrderService orderService, OrderMealService orderMealService) {
        this.orderService = orderService;
        this.orderMealService = orderMealService;
    }

    @GetMapping
    public ApiResponse<List<Order>> list(Order order) {
        List<Order> orders = orderService.list(order);
        return ApiResponse.success(orders);
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getById(@PathVariable Integer id) {
        Order order = orderService.findById(id);
        return ApiResponse.success(order);
    }

    @PostMapping
    public ApiResponse<?> add(@RequestBody Order order) {
        int result = orderService.add(order);
        if (result > 0) {
            return ApiResponse.success("订单添加成功", order);
        } else {
            return ApiResponse.error("订单添加失败");
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Integer id, @RequestBody Order order) {
        order.setId(id);
        int result = orderService.update(order);
        if (result > 0) {
            return ApiResponse.success("订单更新成功", null);
        } else {
            return ApiResponse.error("订单更新失败");
        }
    }

    @GetMapping("/{id}/meals")
    public ApiResponse<List<String>> getMealNames(@PathVariable Integer id) {
        List<String> mealNames = orderService.getMealNamesForOrder(id);
        return ApiResponse.success(mealNames);
    }

    @PostMapping("/{orderId}/meals/{mealId}")
    public ApiResponse<?> addMealToOrder(@PathVariable Integer orderId, @PathVariable Integer mealId) {
        int result = orderMealService.add(orderId, mealId);
        if (result > 0) {
            return ApiResponse.success("菜品添加到订单成功", null);
        } else {
            return ApiResponse.error("菜品添加到订单失败");
        }
    }

    @GetMapping("/phone/{phoneNumber}")
    public ApiResponse<Order> getByPhoneNumber(@PathVariable String phoneNumber) {
        Order order = orderService.findByPhoneNumber(phoneNumber);
        if (order != null) {
            return ApiResponse.success(order);
        } else {
            return ApiResponse.error("未找到该手机号的订单");
        }
    }
}