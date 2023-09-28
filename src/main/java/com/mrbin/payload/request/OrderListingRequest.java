package com.mrbin.payload.request;

import com.mrbin.models.EOrderStatus;
import com.mrbin.models.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderListingRequest {

    @JsonProperty("product")
    public Product product;

    @JsonProperty("buyer")
    public String buyerUserName;

    @JsonProperty("seller")
    public String sellerUserName;

    public OrderListingRequest(Product product, String buyerUserName) {
        this.product = product;
        this.buyerUserName = buyerUserName;
    }
}
