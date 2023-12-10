package com.tobeto.spring.b.java.services.dtos.responses.customer;


import com.tobeto.spring.b.java.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;
}
