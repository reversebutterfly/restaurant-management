package com.restaurant.service.impl;

import com.restaurant.entity.Customer;
import com.restaurant.mapper.CustomerMapper;
import com.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public int add(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Customer findByPhoneNumber(String phoneNumber) {
        return customerMapper.findByPhoneNumber(phoneNumber);
    }
}