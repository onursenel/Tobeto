package com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorporateInvoiceResponse {
    private String contactName;
    private int amount;
}
