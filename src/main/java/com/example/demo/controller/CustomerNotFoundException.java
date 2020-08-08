package com.example.demo.controller;

public class CustomerNotFoundException extends RuntimeException {
    CustomerNotFoundException(Long id) {
        super("Customer not found: " + id);
    }
}
