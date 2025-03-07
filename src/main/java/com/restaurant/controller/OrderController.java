package com.restaurant.controller;

import com.restaurant.entity.Order;
import com.restaurant.service.OrderMealService;
import com.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMealService orderMealService;

    @GetMapping
    public ResponseEntity<List<Order>> list(Order order) {
        List<Order> orders = orderService.list(order);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Order order) {
        int result = orderService.add(order);
        if (result > 0) {
            return ResponseEntity.ok().body("Order added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add order");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Order order) {
        order.setId(id);
        int result = orderService.update(order);
        if (result > 0) {
            return ResponseEntity.ok().body("Order updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update order");
        }
    }

    @GetMapping("/{id}/meals")
    public ResponseEntity<List<String>> getMealNames(@PathVariable Integer id) {
        List<String> mealNames = orderService.getMealNamesForOrder(id);
        return ResponseEntity.ok(mealNames);
    }

    @PostMapping("/{orderId}/meals/{mealId}")
    public ResponseEntity<?> addMealToOrder(@PathVariable Integer orderId, @PathVariable Integer mealId) {
        int result = orderMealService.add(orderId, mealId);
        if (result > 0) {
            return ResponseEntity.ok().body("Meal added to order successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add meal to order");
        }
    }
}