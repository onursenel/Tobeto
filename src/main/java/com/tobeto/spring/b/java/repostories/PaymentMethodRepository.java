package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer>{
}
