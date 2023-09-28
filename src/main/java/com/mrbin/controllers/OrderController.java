package com.mrbin.controllers;

import com.mrbin.models.Order;
import com.mrbin.models.Product;
import com.mrbin.payload.request.OrderListingRequest;
import com.mrbin.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderListingRequest orderListingRequest) {
        Order newOrderObject = orderService.createNewListing(orderListingRequest.getProduct(), orderListingRequest.getBuyerUserName());
        return new ResponseEntity<>(newOrderObject, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getOrderList(@PathVariable("id") String userId) {
        System.out.println(userId);
        return  ResponseEntity.ok("Get order list route");
    }

    public ResponseEntity approveOrder() {
        return ResponseEntity.ok("Approve order route");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllOrder() {
        return  ResponseEntity.ok("Get all order route");
    }
}
