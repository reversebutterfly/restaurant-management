package com.restaurant.controller;

import com.restaurant.entity.Customer;
import com.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Customer customer) {
        int result = customerService.add(customer);
        if (result > 0) {
            return ResponseEntity.ok().body("Customer added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add customer");
        }
    }

    @GetMapping("/{phoneNum}")
    public ResponseEntity<?> getByPhoneNum(@PathVariable String phoneNum) {
        Customer customer = customerService.findByPhoneNum(phoneNum);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}