package com.restaurant.service.impl;

import com.restaurant.entity.Business;
import com.restaurant.mapper.BusinessMapper;
import com.restaurant.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

    private final BusinessMapper businessMapper;

    @Autowired
    public BusinessServiceImpl(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    @Override
    public Business login(String username, String password) {
        return businessMapper.login(username, password);
    }
}