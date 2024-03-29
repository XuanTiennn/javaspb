package com.example.learn.service;


import com.example.learn.model.Order;
import com.example.learn.model.User;
import com.example.learn.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order order) {
        Order _order = orderRepository.findById(orderId).orElse(null);
        if (_order != null) {
            _order.setState(order.getState());
            return orderRepository.save(_order);
        }
        return _order;
    }
}
