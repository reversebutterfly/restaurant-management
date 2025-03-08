package com.restaurant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("meal")
public class Meal {

    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer id;

    @TableField("meal_name")
    private String mealName;

    @TableField("price")
    private BigDecimal price;

    @TableField("is_deleted")
    private Boolean isDeleted;

    public Meal(String mealName, BigDecimal price) {
        this.mealName = mealName;
        this.price = price;
        this.isDeleted = false;
    }

    public Meal(String mealName) {
        this.mealName = mealName;
    }
}