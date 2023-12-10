package com.tobeto.spring.b.java.services.dtos.responses.invoiceDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceDetailResponse {
    private String description;
    private String type;
}
