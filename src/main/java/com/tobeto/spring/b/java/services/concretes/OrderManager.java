package com.tobeto.spring.b.java.services.concretes;


import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.entities.InvoiceDetail;
import com.tobeto.spring.b.java.entities.Order;
import com.tobeto.spring.b.java.repostories.OrderRepository;
import com.tobeto.spring.b.java.services.abstracts.OrderService;
import com.tobeto.spring.b.java.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public List<GetOrderListResponse> getByDate(LocalDate date) {
        List<Order> orders = orderRepository.findByDate(date);
        List<GetOrderListResponse> response = new ArrayList<>();

        for (Order order:orders) {
            Customer customer = new Customer();
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            response.add(new GetOrderListResponse(order.getDate(),order.getRentalStartDate(),order.getRentalEndDate()));
        }

        return response;
    }

    @Override
    public List<GetOrderListResponse> getByDateOrId(LocalDate date, int id) {
        List<Order> orders = orderRepository.findByDateOrId(date,id);
        List<GetOrderListResponse> response = new ArrayList<>();

        for (Order order:orders) {
            Customer customer = new Customer();
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            response.add(new GetOrderListResponse(order.getDate(),order.getRentalStartDate(),order.getRentalEndDate()));
        }

        return response;
    }

    @Override
    public List<GetOrderListResponse> getAll2() {
        return orderRepository.getAll2();
    }

    @Override
    public List<GetOrderListResponse> orderDate() {
        return orderRepository.orderDate();
    }


    @Override
    public List<GetOrderListResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<GetOrderListResponse> getOrderListResponses = new ArrayList<>();

        for (Order order : orders) {
            GetOrderListResponse response = new GetOrderListResponse();
            response.setDate(order.getDate());
            response.setRentalStartDate(order.getRentalStartDate());
            response.setRentalEndDate(order.getRentalEndDate());
            getOrderListResponses.add(response);
        }
        return getOrderListResponses;
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
