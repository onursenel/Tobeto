package com.tobeto.spring.b.java.services.dtos.requests.brand;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    private String name;
    private int modelYear;
    private String productionPlace;
    private String type;
    private String color;
}
