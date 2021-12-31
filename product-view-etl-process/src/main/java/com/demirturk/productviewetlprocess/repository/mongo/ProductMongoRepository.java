package com.demirturk.productviewetlprocess.repository.mongo;

import com.demirturk.productviewetlprocess.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String > {

}
