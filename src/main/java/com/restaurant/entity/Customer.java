package com.restaurant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("customer")
public class Customer {

    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer id;

    @TableField("t_id")
    private Integer tableId;

    @TableField("phone_num")
    private String phoneNumber;

    public Customer(Integer tableId, String phoneNumber) {
        this.tableId = tableId;
        this.phoneNumber = phoneNumber;
    }
}