package com.demirturk.productrecommendapp.util;

import com.demirturk.productrecommendapp.entity.Order;
import com.demirturk.productrecommendapp.entity.OrderItem;
import com.demirturk.productrecommendapp.entity.ProductView;
import com.demirturk.productrecommendapp.repository.OrderItemRepository;
import com.demirturk.productrecommendapp.repository.ProductRepository;
import com.demirturk.productrecommendapp.repository.ProductViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DBInitializeUtil {
    private final ProductViewRepository productViewRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @PostConstruct
    private void init(){
        if (orderItemRepository.count() == 0){
            Pageable limit = PageRequest.of(0,50);
            Page<ProductView> productViewList = productViewRepository.findAll(limit);
            List<OrderItem> orderItemList = productViewList.stream()
                    .map(this::createOrderItem).collect(Collectors.toList());
            orderItemRepository.saveAll(orderItemList);
        }
    }

    private OrderItem createOrderItem(ProductView productView) {
        return OrderItem.builder()
                .order(Order.builder().userId(productView.getUserId())
                        .createdAt(LocalDateTime.now()).build())
                .product(productRepository.findByProductId(productView.getProperties().getProductId()))
                .createdAt(LocalDateTime.now())
                .quantity(1)
                .build();
    }
}
