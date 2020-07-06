package com.assignment.order.handler;

import com.assignment.order.enums.Status;
import com.assignment.order.exception.OrderNotFoundException;
import com.assignment.order.model.Order;
import com.assignment.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class OrderHandler {
    
    @Autowired
    private OrderRepository repository;
    
    Random random = new Random();
    
    //   @Value("${juno.api.auth.token:8e8b0816-4c73-4f08-8f7d-022dcd186a91}")
    @Value("${min.tat.value:10000}")
    private Long minTat;
    
    
    public List<Order> getOrders(Status status) {
        return repository.getOrdersByStatus(status);
    }
    
    public Order updateOrderStatus(Long id, Status status) {
        Order order = repository.getOrderById(id);
        if(null == order){
            throw new OrderNotFoundException("Order not found for id: "+id);
        }
        order.setStatus(status);
        return repository.saveOrUpdate(order);
    }
    
    public Order createOrder(Order order) {
        order.setStatus(Status.NEW);
        order.setCreatedAt(new Date());
        order.setTatDelivery(minTat + random.nextInt(2));
        return repository.saveOrUpdate(order);
    }
    
    public Order getOrder(Long id) {
        Order order = repository.getOrderById(id);
        if(null == order){
            throw new OrderNotFoundException("Order not found for id: "+id);
        }
        return order;
    }
    
    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }
}
