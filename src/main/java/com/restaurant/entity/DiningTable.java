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
@TableName("diningtable")
public class DiningTable {

    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer id;

    @TableField("status")
    private Integer status; // 0表示空闲，1表示占用

    public DiningTable(Integer status) {
        this.status = status;
    }
}