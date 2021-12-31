package com.demirturk.productrecommendapp.repository;

import com.demirturk.productrecommendapp.entity.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
    List<OrderItem> findAllByProductCategoryIdInOrderByCreatedAtDesc(List<String> categoryIdList);

    List<OrderItem> findTop10ByProductCategoryIdInAndOrderUserIdNotInAndCreatedAtBetweenOrderByCreatedAtDesc
            (Collection<String> product_categoryId, Collection<String> order_userId,
             LocalDateTime createdAt, LocalDateTime createdAt2);

    List<OrderItem> findTop10ByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime createdAt, LocalDateTime createdAt2);
}
