package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderService {

    List<GetOrderListResponse> getByDate(LocalDate date);

    List<GetOrderListResponse> getByDateOrId(LocalDate date,int id);



    List<GetOrderListResponse> getAll2();
    List<GetOrderListResponse> orderDate();







    List<GetOrderListResponse> getAll();
    GetOrderResponse getById(int id);
    void add(AddOrderRequest addOrderRequest);
    void update(UpdateOrderRequest updateOrderRequest,int id);
    void delete(int id);


}
