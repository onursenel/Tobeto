package com.tobeto.spring.b.java.services.dtos.requests.paymentDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentDetailRequest {
    private LocalDate transactionDate;
}
