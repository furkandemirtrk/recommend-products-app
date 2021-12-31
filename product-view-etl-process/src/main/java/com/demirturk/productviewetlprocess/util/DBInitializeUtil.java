package com.demirturk.productviewetlprocess.util;

import com.demirturk.productviewetlprocess.entity.Order;
import com.demirturk.productviewetlprocess.entity.OrderItem;
import com.demirturk.productviewetlprocess.entity.Product;
import com.demirturk.productviewetlprocess.entity.ProductView;
import com.demirturk.productviewetlprocess.repository.jpa.OrderItemRepository;
import com.demirturk.productviewetlprocess.repository.mongo.ProductMongoRepository;
import com.demirturk.productviewetlprocess.repository.mongo.ProductViewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Component
public class DBInitializeUtil {

    private final OrderItemRepository orderItemRepository;
    private final ProductViewRepository productViewRepository;
    private final ProductMongoRepository productMongoRepository;

    @PostConstruct
    public void init(){
        if (orderItemRepository.count() == 0) {
            createOrderItem();
        }
        if (productMongoRepository.count() == 0){
            createProduct();
        }

    }

    private void createProduct() {
        Random rand = new Random();
        List<ProductView> productViewList = productViewRepository.findAll();
        Set<Product> productSet = new HashSet<>();
        for (ProductView productView : productViewList){
            if (productSet.stream()
                    .noneMatch(pr -> pr.getProductId().equals(productView.getProperties().getProductId()))){
                productSet.add(Product.builder()
                        .productId(productView.getProperties().getProductId())
                        .categoryId("category-".concat(String.valueOf(rand.nextInt(9))))
                        .build());
            }
        }
        productMongoRepository.saveAll(productSet);
    }

    private void createOrderItem() {
        Order order = Order.builder().userId("user-78").createdAt(LocalDateTime.now()).build();
        Order order2 = Order.builder().userId("user-74").createdAt(LocalDateTime.now()).build();
        Product product = Product.builder().categoryId("category-1").createdAt(LocalDateTime.now()).build();
        Product product2 = Product.builder().categoryId("category-2").createdAt(LocalDateTime.now()).build();


        OrderItem orderItem = OrderItem.builder()
                .product(product)
                .order(order)
                .quantity(5)
                .createdAt(LocalDateTime.now())
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .product(product2)
                .order(order2)
                .quantity(2)
                .createdAt(LocalDateTime.now())
                .build();

        orderItemRepository.saveAll(Arrays.asList(orderItem, orderItem2));
    }

}
