package com.restaurant.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * OrderMeal实体类 - 表示订单与菜品之间的多对多关系
 * 这是一个关联表，使用orderId和mealId作为联合主键
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_meal")
public class OrderMeal {

    /**
     * 订单ID
     */
    @TableField("o_id")
    private Integer orderId;

    /**
     * 菜品ID
     */
    @TableField("m_id")
    private Integer mealId;

    // 可以根据业务需求添加额外字段，如数量、备注等
    // 例如：
    // @TableField("quantity")
    // private Integer quantity;

    // @TableField("remark")
    // private String remark;
}