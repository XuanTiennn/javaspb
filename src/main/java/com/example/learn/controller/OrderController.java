package com.example.learn.controller;

import com.example.learn.model.Order;
import com.example.learn.model.User;
import com.example.learn.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/users/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersByUser(user);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Validate order data
        // Save the order
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);

    }
}