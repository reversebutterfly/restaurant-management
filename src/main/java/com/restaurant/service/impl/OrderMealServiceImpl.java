package com.restaurant.service.impl;

import com.restaurant.entity.OrderMeal;
import com.restaurant.mapper.OrderMealMapper;
import com.restaurant.service.OrderMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderMealServiceImpl implements OrderMealService {

    private final OrderMealMapper orderMealMapper;

    @Autowired
    public OrderMealServiceImpl(OrderMealMapper orderMealMapper) {
        this.orderMealMapper = orderMealMapper;
    }

    @Override
    public int add(int orderId, int mealId) {
        OrderMeal orderMeal = new OrderMeal(orderId, mealId);
        return orderMealMapper.insert(orderMeal);
    }
}