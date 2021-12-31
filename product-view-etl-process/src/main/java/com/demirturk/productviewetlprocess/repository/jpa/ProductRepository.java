package com.demirturk.productviewetlprocess.repository.jpa;

import com.demirturk.productviewetlprocess.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
