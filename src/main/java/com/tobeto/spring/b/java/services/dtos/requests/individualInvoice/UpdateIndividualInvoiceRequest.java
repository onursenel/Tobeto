package com.tobeto.spring.b.java.services.dtos.requests.individualInvoice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateIndividualInvoiceRequest {
    private String name;
    private String surname;
    private int amount;
    private String address;
}
