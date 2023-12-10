package com.tobeto.spring.b.java.services.dtos.responses.invoiceDetail;

import com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice.GetCorporateInvoiceListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceDetailListResponse {

    private String description;
    private String type;
    private GetIndividualInvoiceListResponse getIndividualInvoiceListResponse;
    private GetCorporateInvoiceListResponse getCorporateInvoiceListResponse;
}
