package com.tobeto.spring.b.java.services.dtos.responses.individualInvoice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIndividualInvoiceResponse {
    private String name;
    private int amount;
}
