package com.tobeto.spring.b.java.services.dtos.requests.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private String plate;
    private int rentalFee;
}
