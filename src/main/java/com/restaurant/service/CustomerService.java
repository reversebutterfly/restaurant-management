package com.restaurant.service;

import com.restaurant.entity.Customer;

public interface CustomerService {

    int add(Customer customer);

    Customer findByPhoneNum(String phoneNum);
}