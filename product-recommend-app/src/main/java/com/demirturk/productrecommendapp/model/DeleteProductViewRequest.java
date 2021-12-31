package com.demirturk.productrecommendapp.model;

import lombok.Data;

@Data
public class DeleteProductViewRequest {
    private String userId;
    private String productId;
}
