package com.tobeto.spring.b.java.services.dtos.responses.paymentDetail;

import com.tobeto.spring.b.java.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentDetailListResponse {
    private LocalDate transactionDate;
    private GetPaymentMethodListResponse getPaymentMethodListResponse;
}
