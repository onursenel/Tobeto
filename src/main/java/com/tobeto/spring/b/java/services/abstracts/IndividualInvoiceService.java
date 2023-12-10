package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.AddIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.UpdateIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceResponse;

import java.util.List;

public interface IndividualInvoiceService {

    List<GetIndividualInvoiceListResponse> getByNameLike(String name);

    List<GetIndividualInvoiceListResponse> getByAddress(String address);


    List<GetIndividualInvoiceListResponse> searchName(String name);
    List<GetIndividualInvoiceListResponse> orderAmount();




    List<GetIndividualInvoiceListResponse> getAll();
    GetIndividualInvoiceResponse getById(int id);
    void add(AddIndividualInvoiceRequest addIndividualInvoiceRequest);
    void update(UpdateIndividualInvoiceRequest updateIndividualInvoiceRequest,int id);
    void delete(int id);

}
