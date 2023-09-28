package com.mrbin.service;

import com.mrbin.models.EOrderStatus;
import com.mrbin.models.Order;
import com.mrbin.models.Product;
import com.mrbin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createNewListing(Product product, String buyerUserName) {
        return orderRepository.save(new Order(product, buyerUserName, new Date(), EOrderStatus.PENDING));
    }
}
