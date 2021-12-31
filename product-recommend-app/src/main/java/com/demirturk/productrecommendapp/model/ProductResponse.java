package com.demirturk.productrecommendapp.model;

import com.demirturk.productrecommendapp.model.enums.ViewedProductType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProductResponse {
    private String userId;
    private List<String> products;
    private ViewedProductType type;
}
