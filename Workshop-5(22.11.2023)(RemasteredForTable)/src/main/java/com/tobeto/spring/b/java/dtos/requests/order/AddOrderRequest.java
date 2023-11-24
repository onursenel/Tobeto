package com.tobeto.spring.b.java.dtos.requests.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddOrderRequest {

    private LocalDate date;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;

}
