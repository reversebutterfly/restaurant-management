package com.restaurant.service.impl;

import com.restaurant.entity.Business;
import com.restaurant.mapper.BusinessMapper;
import com.restaurant.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public Business login(String username, String password) {
        return businessMapper.login(username, password);
    }
}