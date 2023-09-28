package com.mrbin.service;

import com.mrbin.models.EOrderStatus;
import com.mrbin.models.Order;
import com.mrbin.models.Product;
import com.mrbin.models.User;
import com.mrbin.payload.response.MessageResponse;
import com.mrbin.repository.OrderRepository;
import com.mrbin.repository.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

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

    public List<Order> getAllListingForASeller(String sellerUserName) {
        return orderRepository.findAllBySellerUserName(sellerUserName);
    }

    public List<Order> getAllListingForABuyer(String buyerUserName) {
        return orderRepository.findAllByBuyerUserName(buyerUserName);
    }

//    For testing purpose
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public ResponseEntity updateOrder(String orderId, EOrderStatus status) {
        Optional<Order> orderQuery = orderRepository.findById(orderId);
        if (orderQuery.isPresent()) {
            Order order = orderQuery.get();
            if(status == EOrderStatus.PENDING) {
                return new ResponseEntity<>(new MessageResponse("No change"), HttpStatus.NOT_MODIFIED);
            } else if (status == EOrderStatus.REJECTED) {
                Date resolvedAt = new Date();
                order.setResolvedAt(resolvedAt);
                order.setOrderStatus(status);
                orderRepository.save(order);

                return new ResponseEntity<>(new MessageResponse("Order " + orderId + " has been rejected"), HttpStatus.OK);
            } else {
                Product product = order.getProduct();
                Optional<User> buyerQuery = userRepository.findByUsername(order.buyerUserName);
                if(buyerQuery.isPresent()) {
                    String buyerId = buyerQuery.get().getId();
                    product.setBuyerId(buyerId);
                    productRepository.save(product);

                    Date resolvedAt = new Date();
                    order.setResolvedAt(resolvedAt);
                    order.setOrderStatus(status);
                    orderRepository.save(order);

                    return new ResponseEntity<>(new MessageResponse("Order " + orderId + " has been successfully completed"), HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(new MessageResponse("Order not found"), HttpStatus.NOT_FOUND);
    }
}
