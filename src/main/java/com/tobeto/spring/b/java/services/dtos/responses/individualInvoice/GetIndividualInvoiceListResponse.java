package com.tobeto.spring.b.java.services.dtos.responses.individualInvoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIndividualInvoiceListResponse {
    private String name;
    private String surname;
    private int amount;

}
