package com.demirturk.productrecommendapp.service.impl;

import com.demirturk.productrecommendapp.entity.ProductView;
import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.exception.enums.ErrorCodeEnum;
import com.demirturk.productrecommendapp.model.DeleteProductViewRequest;
import com.demirturk.productrecommendapp.model.ProductResponse;
import com.demirturk.productrecommendapp.model.enums.ViewedProductType;
import com.demirturk.productrecommendapp.repository.ProductViewRepository;
import com.demirturk.productrecommendapp.service.ProductViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductViewServiceImpl implements ProductViewService {

    private final ProductViewRepository productViewRepository;

    @Override
    public ProductResponse getLastTenProductsViewedByUser(String userId) throws ProductRecommendAppException {
        if (ObjectUtils.isEmpty(userId)){
            log.error("user id is can not be empty");
            throw new ProductRecommendAppException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        List<ProductView> productViewList = productViewRepository.findTop10ByUserId(userId);
        ProductResponse productResponse =
                ProductResponse.builder()
                        .type(ViewedProductType.personalized)
                        .products(new ArrayList<>())
                        .userId(userId)
                        .build();
        productResponse.setProducts(productViewList
                .stream()
                .map(view -> view.getProperties().getProductId()).collect(Collectors.toList()));
        return productResponse;
    }

    @Override
    public Boolean deleteProductViewByUserIdAndProductId(DeleteProductViewRequest deleteProductViewRequest) {
        try {
            if (ObjectUtils.isEmpty(deleteProductViewRequest)
                    || ObjectUtils.isEmpty(deleteProductViewRequest.getProductId())
                    || ObjectUtils.isEmpty(deleteProductViewRequest.getUserId())) {
                log.error("parameters can not be empty");
                throw new ProductRecommendAppException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
            }
            productViewRepository.deleteByPropertiesProductIdAndUserId(
                    deleteProductViewRequest.getProductId(), deleteProductViewRequest.getUserId());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
