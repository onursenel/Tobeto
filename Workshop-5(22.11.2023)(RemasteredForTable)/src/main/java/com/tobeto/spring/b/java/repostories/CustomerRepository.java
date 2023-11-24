package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
