package com.demirturk.productviewetlprocess.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@EnableJpaRepositories
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String orderId;

    @Column
    private String userId;

    @Transient
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItemSet;

    @Column
    private LocalDateTime createdAt;

}
