package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
