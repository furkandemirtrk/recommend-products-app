package com.demirturk.productrecommendapp.service.impl;

import com.demirturk.productrecommendapp.entity.OrderItem;
import com.demirturk.productrecommendapp.entity.ProductView;
import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.exception.enums.ErrorCodeEnum;
import com.demirturk.productrecommendapp.model.ProductResponse;
import com.demirturk.productrecommendapp.model.enums.ViewedProductType;
import com.demirturk.productrecommendapp.repository.OrderItemRepository;
import com.demirturk.productrecommendapp.repository.ProductRepository;
import com.demirturk.productrecommendapp.repository.ProductViewRepository;
import com.demirturk.productrecommendapp.service.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class RecommendServiceImpl implements RecommendService {

    private final ProductViewRepository productViewRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Override
    public ProductResponse recommendProduct(String userId) throws ProductRecommendAppException {
        if (ObjectUtils.isEmpty(userId)) {
            log.error("userId can not be empty");
            throw new ProductRecommendAppException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        List<ProductView> productViewList = productViewRepository.findAllByUserId(userId);
        if (productViewList.isEmpty()) {
            return getNonPersonalProductResponse(userId);
        } else {
            return getPersonalProductResponse(userId, productViewList);
        }
    }

    private ProductResponse getPersonalProductResponse(String userId, List<ProductView> productViewList) {
        List<String> categoryList = productViewList.stream()
                .map(pv ->
                        productRepository.findByProductId(pv.getProperties().getProductId()).getCategoryId())
                .collect(Collectors.toList());

        List<OrderItem> orderItemList = orderItemRepository
                .findTop10ByProductCategoryIdInAndOrderUserIdNotInAndCreatedAtBetweenOrderByCreatedAtDesc
                        (categoryList, Collections.singletonList(userId),
                                LocalDateTime.now().minusMonths(1L), LocalDateTime.now());

        return getProductResponse(userId, orderItemList, ViewedProductType.personalized);
    }

    private ProductResponse getNonPersonalProductResponse(String userId) {
        List<OrderItem> orderItemList = orderItemRepository
                .findTop10ByCreatedAtBetweenOrderByCreatedAtDesc
                        (LocalDateTime.now().minusMonths(1L), LocalDateTime.now());
        return getProductResponse(userId, orderItemList, ViewedProductType.non_personalized);
    }

    private ProductResponse getProductResponse(String userId, List<OrderItem> orderItemList, ViewedProductType type) {
        ProductResponse productResponse = ProductResponse.builder()
                .type(type)
                .userId(userId)
                .products(new ArrayList<>())
                .build();
        if (orderItemList.size() > 4) {
            productResponse.setProducts(
                    orderItemList.stream()
                            .map(orderItem -> orderItem.getProduct().getProductId()).collect(Collectors.toList()));
        }
        return productResponse;
    }
}
