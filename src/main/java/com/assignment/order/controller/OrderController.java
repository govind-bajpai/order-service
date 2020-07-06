package com.assignment.order.controller;

import com.assignment.order.enums.Status;
import com.assignment.order.handler.OrderHandler;
import com.assignment.order.model.Order;
import com.assignment.order.repository.OrderRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderHandler handler;
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return handler.getOrder(id);
        
    }
    
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        return handler.createOrder(order);
        
    }
    
    @GetMapping("status/{status}")
    public List<Order> getOrder(@PathVariable Status status){
        return handler.getOrders(status);
        
    }
    
    @GetMapping("/getAllOrders")
    public List<Order> getOrder(){
        return handler.getAllOrders();
        
    }
    
    @PostMapping("/{id}/status")
    public Order updateStatus(@PathVariable(required = true) Long id,@RequestBody(required = true) String status){
        return handler.updateOrderStatus(id,Status.valueOf(status));
        
    }
}
