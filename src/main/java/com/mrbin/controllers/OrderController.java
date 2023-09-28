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
import java.util.Optional;

@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    public ResponseEntity placeOrder(@RequestBody OrderListingRequest orderListingRequest) {
        ResponseEntity response = orderService.createNewListing(orderListingRequest.getProduct(), orderListingRequest.getBuyerUserName());
        return response;
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
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }
}
