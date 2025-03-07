package com.restaurant.service.impl;

import com.restaurant.entity.Customer;
import com.restaurant.mapper.CustomerMapper;
import com.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int add(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Customer findByPhoneNum(String phoneNum) {
        return customerMapper.findByPhoneNum(phoneNum);
    }
}