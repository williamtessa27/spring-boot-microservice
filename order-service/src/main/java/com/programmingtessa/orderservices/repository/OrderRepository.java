package com.programmingtessa.orderservices.repository;

import com.programmingtessa.orderservices.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
