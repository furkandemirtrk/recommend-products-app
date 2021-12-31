package com.demirturk.productviewetlprocess.repository.mongo;

import com.demirturk.productviewetlprocess.entity.ProductView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductViewRepository extends MongoRepository<ProductView, String> {
}
