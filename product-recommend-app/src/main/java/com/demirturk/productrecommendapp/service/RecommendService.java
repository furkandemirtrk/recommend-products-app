package com.demirturk.productrecommendapp.service;

import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface RecommendService {
    ProductResponse recommendProduct(String userId) throws ProductRecommendAppException;
}
