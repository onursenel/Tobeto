package com.tobeto.spring.b.java.dtos.responses.customer;


import com.tobeto.spring.b.java.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private List<Customer> customers;
}
