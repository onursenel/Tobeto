package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;

public interface OrderService {
    GetOrderListResponse getAll();
    GetOrderResponse getById(int id);
    void add(AddOrderRequest addOrderRequest);
    void update(UpdateOrderRequest updateOrderRequest,int id);
    void delete(int id);


}
