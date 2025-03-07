package com.restaurant.service;

import com.restaurant.entity.Order;
import java.util.List;

public interface OrderService {

    List<Order> list(Order order);

    int update(Order order);

    int add(Order order);

    List<String> getMealNamesForOrder(int orderId);

    Order findByPhoneNum(String phoneNum);
}