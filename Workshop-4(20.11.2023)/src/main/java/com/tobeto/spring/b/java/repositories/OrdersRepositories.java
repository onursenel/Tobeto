package com.tobeto.spring.b.java.repositories;

import com.tobeto.spring.b.java.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepositories extends JpaRepository <Orders, Integer> {
}
