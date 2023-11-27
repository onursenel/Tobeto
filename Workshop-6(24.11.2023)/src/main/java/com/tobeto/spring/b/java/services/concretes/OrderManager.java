package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.Order;
import com.tobeto.spring.b.java.repostories.OrderRepository;
import com.tobeto.spring.b.java.services.abstracts.OrderService;
import com.tobeto.spring.b.java.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public GetOrderListResponse getAll() {
        GetOrderListResponse orderList = new GetOrderListResponse();
        orderList.setOrders(orderRepository.findAll());
        return orderList;
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();


        GetOrderResponse orderDto = new GetOrderResponse();
        orderDto.setDate(order.getDate());
        orderDto.setRentalStartDate(order.getRentalStartDate());
        orderDto.setRentalEndDate(order.getRentalEndDate());

        return orderDto;
    }

    @Override
    public void add(AddOrderRequest addOrderRequest) {
        Order order = new Order();

        order.setDate(addOrderRequest.getDate());
        order.setRentalStartDate(addOrderRequest.getRentalStartDate());
        order.setRentalEndDate(addOrderRequest.getRentalEndDate());

        orderRepository.save(order);

    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest,int id) {
        Order order = orderRepository.findById(id).orElseThrow();


        order.setDate(updateOrderRequest.getDate());
        order.setRentalStartDate(updateOrderRequest.getRentalStartDate());
        order.setRentalEndDate(updateOrderRequest.getRentalEndDate());

        orderRepository.save(order);

    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);

    }
}
