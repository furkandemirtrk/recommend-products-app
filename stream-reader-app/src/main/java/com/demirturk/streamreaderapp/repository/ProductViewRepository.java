package com.demirturk.streamreaderapp.repository;

import com.demirturk.streamreaderapp.model.ProductView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductViewRepository extends MongoRepository<ProductView, String> {
}
