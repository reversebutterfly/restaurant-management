package com.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.restaurant.entity.Order;
import com.restaurant.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import com.restaurant.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> list(Order order) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (order != null) {
            if (order.getId() != null && order.getId() != 0) {
                queryWrapper.eq("o_id", order.getId());
            }
            if (StringUtil.isNotEmpty(order.getPhoneNum())) {
                queryWrapper.eq("phone_num", order.getPhoneNum());
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
    public Order findByPhoneNum(String phoneNum) {
        return orderMapper.findByPhoneNum(phoneNum);
    }
}