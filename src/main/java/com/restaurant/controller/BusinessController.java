package com.restaurant.controller;

import com.restaurant.entity.Business;
import com.restaurant.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Business loginRequest) {
        Business business = businessService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (business != null) {
            return ResponseEntity.ok(business);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}