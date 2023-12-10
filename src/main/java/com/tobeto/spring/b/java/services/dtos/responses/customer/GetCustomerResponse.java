package com.tobeto.spring.b.java.services.dtos.responses.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;
}
