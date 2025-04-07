package com.springcore.springcoredemo.controller;

import com.springcore.springcoredemo.daos.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderController {

    Order order;

    @Autowired
    public   OrderController(Order order){
        this.order=order;
    }

    public static void main(String[] args) {

    }

}
