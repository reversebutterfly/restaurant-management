package com.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restaurant.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT meal_name FROM meal JOIN order_meal ON meal.m_id = order_meal.m_id WHERE order_meal.o_id = #{orderId}")
    List<String> getMealNamesForOrder(@Param("orderId") int orderId);

    @Select("SELECT * FROM `order` WHERE phone_num = #{phoneNumber} ORDER BY o_id DESC LIMIT 1")
    Order findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}