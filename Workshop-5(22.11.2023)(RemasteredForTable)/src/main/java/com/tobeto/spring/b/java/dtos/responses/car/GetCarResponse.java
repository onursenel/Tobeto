package com.tobeto.spring.b.java.dtos.responses.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private String plate ;
    private int rentalFee;
}
