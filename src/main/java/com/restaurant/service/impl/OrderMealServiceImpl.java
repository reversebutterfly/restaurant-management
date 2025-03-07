package com.restaurant.service.impl;

import com.restaurant.mapper.OrderMealMapper;
import com.restaurant.service.OrderMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMealServiceImpl implements OrderMealService {

    @Autowired
    private OrderMealMapper orderMealMapper;

    @Override
    public int add(int orderId, int mealId) {
        return orderMealMapper.addMealToOrder(orderId, mealId);
    }
}