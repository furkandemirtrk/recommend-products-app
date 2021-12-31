package com.demirturk.productviewetlprocess.repository.jpa;

import com.demirturk.productviewetlprocess.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
