package com.demirturk.productviewetlprocess.batch.productView;

import com.demirturk.productviewetlprocess.entity.OrderItem;
import com.demirturk.productviewetlprocess.entity.Context;
import com.demirturk.productviewetlprocess.entity.ProductView;
import com.demirturk.productviewetlprocess.entity.Properties;
import com.demirturk.productviewetlprocess.exception.EtlProcessException;
import com.demirturk.productviewetlprocess.exception.enums.ErrorCodeEnum;
import com.demirturk.productviewetlprocess.repository.jpa.OrderItemRepository;
import com.demirturk.productviewetlprocess.repository.mongo.OrderItemMongoRepository;
import com.demirturk.productviewetlprocess.repository.mongo.ProductViewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ProductViewTransformProcess {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMongoRepository orderItemMongoRepository;
    private final ProductViewRepository productViewRepository;

    public void run() throws EtlProcessException {
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        if (orderItemList.isEmpty()) {
            log.error("order list is empty");
            throw new EtlProcessException(ErrorCodeEnum.ORDER_LIST_IS_EMPTY);
        }
        orderItemMongoRepository.saveAll(orderItemList);

//        List<ProductView> productViewList =
//                orderItemList.stream().map(this::createProductView).collect(Collectors.toList());

//        productViewRepository.saveAll(productViewList);
        orderItemRepository.deleteAll(orderItemList);
    }

    private ProductView createProductView(OrderItem orderItem) {
        return ProductView.builder()
                .context(Context.builder().source("desktop").build())
                .properties(Properties.builder()
                        .productId(orderItem.getProduct().getProductId())
                        .build())
                .event("Order")
                .userId(orderItem.getOrder().getUserId())
                .build();
    }

}
