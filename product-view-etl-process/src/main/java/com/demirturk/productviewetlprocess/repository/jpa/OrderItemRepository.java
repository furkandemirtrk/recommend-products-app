package com.demirturk.productviewetlprocess.repository.jpa;

import com.demirturk.productviewetlprocess.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
