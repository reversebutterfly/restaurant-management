package com.restaurant.service;

import com.restaurant.entity.Business;

public interface BusinessService {

    Business login(String username, String password);
}