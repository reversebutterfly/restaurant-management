package com.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.restaurant.entity.Order;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import com.restaurant.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> list(Order order) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        if (order != null) {
            if (order.getId() != null && order.getId() != 0) {
                queryWrapper.eq(Order::getId, order.getId());
            }
            if (StringUtil.isNotEmpty(order.getPhoneNumber())) {
                queryWrapper.eq(Order::getPhoneNumber, order.getPhoneNumber());
            }
        }
        return orderMapper.selectList(queryWrapper);
    }

    @Override
    public int update(Order order) {
        return orderMapper.updateById(order);
    }

    @Override
    public int add(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public List<String> getMealNamesForOrder(int orderId) {
        return orderMapper.getMealNamesForOrder(orderId);
    }

    @Override
    public Order findByPhoneNumber(String phoneNumber) {
        return orderMapper.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Order findById(Integer id) {
        Order order = orderMapper.selectById(id);
        if (order == null) {
            throw new ResourceNotFoundException("Order", "id", id);
        }
        return order;
    }
}