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
@TableName("order")
public class Order {

    @TableId(value = "o_id", type = IdType.AUTO)
    private Integer id;

    @TableField("t_id")
    private Integer tableId;

    @TableField("c_id")
    private Integer customerId;

    @TableField("phone_num")
    private String phoneNumber;

    @TableField("cost_money")
    private BigDecimal costMoney;

    public Order(Integer tableId, Integer customerId, String phoneNumber, BigDecimal costMoney) {
        this.tableId = tableId;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.costMoney = costMoney;
    }

    public Order(Integer tableId, Integer customerId, String phoneNumber) {
        this.tableId = tableId;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
    }

    public Order(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Order(Integer id, BigDecimal costMoney) {
        this.id = id;
        this.costMoney = costMoney;
    }
}