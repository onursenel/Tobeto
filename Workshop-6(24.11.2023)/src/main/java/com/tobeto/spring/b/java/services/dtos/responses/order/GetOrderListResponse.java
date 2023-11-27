package com.tobeto.spring.b.java.services.dtos.responses.order;


import com.tobeto.spring.b.java.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderListResponse {
    private List<Order> orders;
}
