package com.mrbin.service;

import com.mrbin.models.EOrderStatus;
import com.mrbin.models.Order;
import com.mrbin.models.Product;
import com.mrbin.models.User;
import com.mrbin.payload.response.MessageResponse;
import com.mrbin.repository.OrderRepository;
import com.mrbin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity createNewListing(Product product, String buyerUserName) {
        Optional<User> seller = userRepository.findById(product.getUserId());
        if(seller.isPresent()) {
            Order issedOrder = orderRepository.save(new Order(product, buyerUserName, seller.get().getUsername(), new Date(), EOrderStatus.PENDING));
            return new ResponseEntity(issedOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new MessageResponse("Seller not found"), HttpStatus.NOT_FOUND);
        }
    }

//    For testing purpose
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
