package com.assignment.order.repository;

import com.assignment.order.enums.Status;
import com.assignment.order.model.Order;

import java.util.List;
import java.util.Optional;


public interface OrderRepository {
    public Order saveOrUpdate(Order order);
    public Order getOrderById(Long id);
    public List<Order> getOrdersByStatus(Status status);
    public List<Order> getAllOrders();
}
