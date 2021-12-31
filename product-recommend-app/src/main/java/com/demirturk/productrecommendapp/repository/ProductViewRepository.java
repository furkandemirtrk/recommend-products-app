package com.demirturk.productrecommendapp.repository;

import com.demirturk.productrecommendapp.entity.ProductView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductViewRepository extends MongoRepository<ProductView, String> {
    List<ProductView> findTop10ByUserId(String userId);
    List<ProductView> findAllByUserId(String userId);
    Long deleteByPropertiesProductIdAndUserId(String productId, String userId);

}
