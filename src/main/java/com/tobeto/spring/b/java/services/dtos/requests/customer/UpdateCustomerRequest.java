package com.tobeto.spring.b.java.services.dtos.requests.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCustomerRequest {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;

}
