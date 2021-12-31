package com.demirturk.productrecommendapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document("product")
public class Product {
    @JsonProperty("productId")
    private String productId;

    @JsonProperty("categoryId")
    private String categoryId;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
}
