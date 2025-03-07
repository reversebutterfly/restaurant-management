package com.restaurant.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(prefix = {"o_", "t_", "c_"}) // 这告诉Lombok处理这些前缀
public class Order {
    int o_id;   // 将自动生成 getId() 和 setId()
    int t_id;   // 将自动生成 getTId() 和 setTId()
    int c_id;   // 将自动生成 getCId() 和 setCId()
    String phone_num;
    BigDecimal cost_money;

    // 保留必要的构造函数
    public Order(int t_id, int c_id, String phone_num, BigDecimal cost_money) {
        this.t_id = t_id;
        this.c_id = c_id;
        this.phone_num = phone_num;
        this.cost_money = cost_money;
    }

    public Order(int t_id, int c_id, String phone_num) {
        this.t_id = t_id;
        this.c_id = c_id;
        this.phone_num = phone_num;
    }

    public Order(String phone_num) {
        this.phone_num = phone_num;
    }

    public Order(int o_id, BigDecimal cost_money) {
        this.o_id = o_id;
        this.cost_money = cost_money;
    }
}