package com.tobeto.spring.b.java.services.dtos.responses.car;

import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse{
    private int id;
    private String plate;
    private int rentalFee;
    private GetBrandListResponse brand;
}
