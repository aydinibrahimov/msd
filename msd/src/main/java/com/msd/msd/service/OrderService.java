package com.msd.msd.service;


import com.msd.msd.entity.Order;
import com.msd.msd.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }


    public Order updateOrderById(Order order, Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return orderRepository.save(order);
        } else {
            return optionalOrder
                    .orElseThrow(() -> new RuntimeException("It failed to find the order with the ID of " + id));
        }
    }


    public void deletOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            optionalOrder
                    .orElseThrow(() -> new RuntimeException("It failed to find the order with the ID of " + id));
        }
    }


    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It failed to find the order with the ID of " + id));
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
