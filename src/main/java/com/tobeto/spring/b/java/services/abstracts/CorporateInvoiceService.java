package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.AddCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.UpdateCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice.GetCorporateInvoiceListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice.GetCorporateInvoiceResponse;

public interface CorporateInvoiceService {

    GetCorporateInvoiceResponse getById(int id);
    void add(AddCorporateInvoiceRequest addCorporateInvoiceRequest);
    void update(UpdateCorporateInvoiceRequest updateCorporateInvoiceRequest,int id);
    void delete(int id);

}
