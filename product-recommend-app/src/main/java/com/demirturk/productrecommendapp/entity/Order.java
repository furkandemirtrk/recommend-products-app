package com.demirturk.productrecommendapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document("orders")
public class Order {
    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

}
