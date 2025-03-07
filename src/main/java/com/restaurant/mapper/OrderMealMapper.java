package com.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restaurant.entity.OrderMeal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMealMapper extends BaseMapper<OrderMeal> {

    @Insert("INSERT INTO order_meal VALUES (#{orderId}, #{mealId})")
    int addMealToOrder(@Param("orderId") int orderId, @Param("mealId") int mealId);
}