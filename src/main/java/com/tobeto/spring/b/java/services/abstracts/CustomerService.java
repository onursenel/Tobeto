package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetCustomerListResponse> getByNameLike(String name);
    List<GetCustomerListResponse> getByNameIgnoreCase(String name);


    List<GetCustomerListResponse> searchCustomerName(String name);
    List<GetCustomerListResponse> orderName();



    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest, int id);
    void delete(int id);
}
