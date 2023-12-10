package com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice;

import com.tobeto.spring.b.java.entities.CorporateInvoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorporateInvoiceListResponse {
    private String contactName;
    private String contactAddress;
    private int amount;

}
