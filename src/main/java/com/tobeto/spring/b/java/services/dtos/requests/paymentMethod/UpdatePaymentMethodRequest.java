package com.tobeto.spring.b.java.services.dtos.requests.paymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentMethodRequest {
    private String type;
    private String creditCardInformation;
    private String moneyType;
}
