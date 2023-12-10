package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail,Integer> {
}
