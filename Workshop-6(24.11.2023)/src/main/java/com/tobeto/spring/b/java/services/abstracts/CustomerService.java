package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerResponse;

public interface CustomerService {
    GetCustomerListResponse getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest, int id);
    void delete(int id);
}
