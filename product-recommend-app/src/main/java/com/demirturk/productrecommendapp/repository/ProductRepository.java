package com.demirturk.productrecommendapp.repository;

import com.demirturk.productrecommendapp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByProductId(String productId);
}
