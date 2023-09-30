package com.mrbin.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrbin.models.EStates.EOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    public String id;

    @JsonProperty("product")
    @Field(name = "product")
    public Product product;

    @JsonProperty("buyer")
    @Field(name = "buyer")
    public String buyerUserName;

    @JsonProperty("seller")
    @Field(name = "seller")
    public String sellerUserName;

    @JsonProperty("created-at")
    @Field(name = "created-at")
    public Date createdAt;

    @JsonProperty("resolved-at")
    @Field(name = "resolved-at")
    public Date resolvedAt;

    @JsonProperty("status")
    @Field(name = "status")
    public EOrderStatus orderStatus;

    public Order(Product product, String buyerUserName, String sellerUserName, Date createdAt, EOrderStatus orderStatus) {
        this.product = product;
        this.buyerUserName = buyerUserName;
        this.sellerUserName = sellerUserName;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
    }
}
