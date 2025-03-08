package com.restaurant.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_meal")
public class OrderMeal {

    @TableField("o_id")
    private Integer orderId;

    @TableField("m_id")
    private Integer mealId;
}