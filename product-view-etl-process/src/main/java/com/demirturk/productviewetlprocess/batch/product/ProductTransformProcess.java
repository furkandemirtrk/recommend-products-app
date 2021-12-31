package com.demirturk.productviewetlprocess.batch.product;

import com.demirturk.productviewetlprocess.entity.Product;
import com.demirturk.productviewetlprocess.exception.EtlProcessException;
import com.demirturk.productviewetlprocess.exception.enums.ErrorCodeEnum;
import com.demirturk.productviewetlprocess.repository.jpa.ProductRepository;
import com.demirturk.productviewetlprocess.repository.mongo.ProductMongoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ProductTransformProcess {


    private final ProductMongoRepository productMongoRepository;
    private final ProductRepository productRepository;

    public void run() throws EtlProcessException {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()){
            throw new EtlProcessException(ErrorCodeEnum.PRODUCT_LIST_IS_EMPTY);
        }
        productMongoRepository.saveAll(productList);
        productRepository.deleteAll(productList);

    }
}
