package com.bezkoder.spring.jwt.mongodb.models;

import com.bezkoder.spring.jwt.mongodb.utils.Avatar;
import com.bezkoder.spring.jwt.mongodb.utils.Comment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "category")
    private String category;

    @Field(name = "address")
    private String address;
//
//    @Field(name = "isVerified")
//    private Boolean isVerified = false;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "condition")
    private String condition = "used";

    @Field(name = "images")
    private List<Avatar> images;

    @Field(name = "user")
    private String userId; // Assuming this is the user ID as a string

    @Field(name = "buyer")
    private String buyerId; // Assuming this is the buyer ID as a string

    @Field(name = "product_type")
    private String productType = "marketplace";

    @Field(name = "description")
    private String description;

    @Field(name = "date_of_purchase")
    private String dateOfPurchase;

    @Field(name = "purchase_price")
    private Double purchasePrice;

//    @Field(name = "bids")
//    private List<Bid> bids;

    @Field(name = "comments")
    private List<Comment> comments;

    @Field(name = "created_at")
    private Date createdAt = new Date();

    // Constructors, getters, setters, and other methods...

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", address=" + address +
//                ", isVerified=" + isVerified +
                ", quantity=" + quantity +
                ", condition='" + condition + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", productType='" + productType + '\'' +
                ", description='" + description + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", purchasePrice=" + purchasePrice +
//                ", bids=" + bids +
                ", comments=" + comments +
                ", createdAt=" + createdAt +
                '}';
    }

    public Product(String name, String category, String address, Integer quantity, String condition, String userId, String productType, String dateOfPurchase, Double purchasePrice) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.quantity = quantity;
        this.condition = condition;
        this.userId = userId;
        this.productType = productType;
        this.dateOfPurchase = dateOfPurchase;
        this.purchasePrice = purchasePrice;
    }
}