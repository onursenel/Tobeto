package com.tobeto.spring.b.java.dtos.requests.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private String plate;
    private int rentalFee;
}
