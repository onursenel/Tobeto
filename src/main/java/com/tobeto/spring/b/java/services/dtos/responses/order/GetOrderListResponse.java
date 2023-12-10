package com.tobeto.spring.b.java.services.dtos.responses.order;


import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.entities.InvoiceDetail;
import com.tobeto.spring.b.java.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderListResponse {
    private LocalDate date;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
}
