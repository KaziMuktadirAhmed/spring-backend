package com.mrbin.controllers;

import com.mrbin.models.Product;
import com.mrbin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK) ;
    }

    @PostMapping(value = "product/new")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        System.out.println(product);
//        Product createdProduct = productService.createProduct(new Product());
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

}
