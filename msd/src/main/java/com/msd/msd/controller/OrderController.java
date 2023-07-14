package com.msd.msd.controller;

import com.msd.msd.entity.Order;
import com.msd.msd.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msd/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order insertOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }


    @PutMapping("/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable Long id) {
        return orderService.updateOrderById(order, id);
    }


    @DeleteMapping("/{id}")
    public void removeOrder(@PathVariable Long id) {
        orderService.deletOrderById(id);
    }


    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.getAllOrders();
    }

}
