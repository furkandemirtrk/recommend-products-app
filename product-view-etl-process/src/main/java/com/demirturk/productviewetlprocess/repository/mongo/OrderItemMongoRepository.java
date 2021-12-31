package com.demirturk.productviewetlprocess.repository.mongo;

import com.demirturk.productviewetlprocess.entity.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMongoRepository extends MongoRepository<OrderItem, String> {
}
