package com.demirturk.productrecommendapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document("order_items")
public class OrderItem {
    @JsonProperty("orderitemId")
    private String id;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("order")
    private Order order;

    @JsonProperty("quantity")
    private int quantity = 0;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
}
