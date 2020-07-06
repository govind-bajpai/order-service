package com.assignment.order.repository;

import com.assignment.order.enums.Status;
import com.assignment.order.model.Order;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryImpl implements OrderRepository{
    
    private final Map<Long,Order> orderDataMap = new HashMap<>();
    private final AtomicLong id = new AtomicLong(0);
    
    @Override
    public Order saveOrUpdate(Order order) {
        if(null != order.getId()){
            orderDataMap.put(order.getId(),order);
        }else{
            order.setId(id.incrementAndGet());
            orderDataMap.put(order.getId(),order);
        }
        return order;
    }
    
    @Override
    public Order getOrderById(Long id) {
        return orderDataMap.get(id);
    }
    
    @Override
    public List<Order> getOrdersByStatus(Status status) {
        return orderDataMap.values().stream().filter(e -> status.equals(e.getStatus())).collect(Collectors.toList());
    }
    
    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderDataMap.values());
    }
}
