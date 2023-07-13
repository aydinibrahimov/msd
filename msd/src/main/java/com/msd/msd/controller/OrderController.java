package com.msd.msd.controller;

import com.msd.msd.entity.Order;
import com.msd.msd.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order insertOrder(Order order) {
        return orderService.addOrder(order);
    }


    @PutMapping
    public Order updateOrder(Order order, Long id) {
        return orderService.updateOrderById(order, id);
    }


    @DeleteMapping
    public void removeOrder(Long id) {
        orderService.deletOrderById(id);
    }


    @GetMapping("/{id}")
    public Order findorderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/list")
    public List<Order> findAllOrders() {
        return orderService.getAllOrders();
    }

}
