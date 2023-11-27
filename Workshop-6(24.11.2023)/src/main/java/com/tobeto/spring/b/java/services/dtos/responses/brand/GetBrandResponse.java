package com.tobeto.spring.b.java.services.dtos.responses.brand;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandResponse {
    private String name;
    private int model_year;
    //private String production_place;
    private String type;
    private String color;
}
