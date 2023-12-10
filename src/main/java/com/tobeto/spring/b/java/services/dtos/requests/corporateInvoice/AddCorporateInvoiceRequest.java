package com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateInvoiceRequest {
    private String contactName;
    private String contactAddress;
    private String phoneNumber;
    private String taxNumber;
    private int amount;
}
