package com.tobeto.spring.b.java.services.dtos.responses.brand;


import com.tobeto.spring.b.java.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListResponse {
    private List<Brand> brands;
}
