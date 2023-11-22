package com.tobeto.spring.b.java.repositories;

import com.tobeto.spring.b.java.entities.Customers;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository <Customers, Integer> {
}
