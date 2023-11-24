package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.b.java.entities.Order;
import com.tobeto.spring.b.java.repostories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }



    @GetMapping
    public GetOrderListResponse getAll(){
        GetOrderListResponse orderList = new GetOrderListResponse();
        orderList.setOrders(orderRepository.findAll());
        return orderList;
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        Order order = orderRepository.findById(id).orElseThrow();


        GetOrderResponse orderDto = new GetOrderResponse();
        orderDto.setDate(order.getDate());
        orderDto.setRentalStartDate(order.getRentalStartDate());
        orderDto.setRentalEndDate(order.getRentalEndDate());

        return orderDto;

    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        Order order = new Order();

        order.setDate(addOrderRequest.getDate());
        order.setRentalStartDate(addOrderRequest.getRentalStartDate());
        order.setRentalEndDate(addOrderRequest.getRentalEndDate());

        orderRepository.save(order);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateOrderRequest updateOrderRequest,@PathVariable int id){
        Order order = orderRepository.findById(id).orElseThrow();


        order.setDate(updateOrderRequest.getDate());
        order.setRentalStartDate(updateOrderRequest.getRentalStartDate());
        order.setRentalEndDate(updateOrderRequest.getRentalEndDate());

        orderRepository.save(order);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.deleteById(id);
    }

}
