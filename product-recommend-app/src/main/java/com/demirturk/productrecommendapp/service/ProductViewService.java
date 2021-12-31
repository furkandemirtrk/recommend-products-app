package com.demirturk.productrecommendapp.service;

import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.model.DeleteProductViewRequest;
import com.demirturk.productrecommendapp.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductViewService {
    ProductResponse getLastTenProductsViewedByUser(String userId) throws ProductRecommendAppException;
    Boolean deleteProductViewByUserIdAndProductId(DeleteProductViewRequest deleteProductViewRequest);
}
