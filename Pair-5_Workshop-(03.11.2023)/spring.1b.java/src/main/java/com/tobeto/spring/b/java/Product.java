

package com.tobeto.spring.b.java;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private String brand;
    private int unitPrice;
    private String color;
    private String size;
    private String feature;

}


