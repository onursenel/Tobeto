package com.tobeto.spring.b.java.services.abstracts;


import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.AddInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.UpdateInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.invoiceDetail.GetInvoiceDetailResponse;

public interface InvoiceDetailService {

    GetInvoiceDetailResponse getById(int id);
    void add(AddInvoiceDetailRequest addInvoiceDetailRequest);
    void update(UpdateInvoiceDetailRequest updateInvoiceDetailRequest,int id);
    void delete(int id);

}
