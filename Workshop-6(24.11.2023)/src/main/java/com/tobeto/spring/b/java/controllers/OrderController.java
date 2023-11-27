package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.OrderService;
import com.tobeto.spring.b.java.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.java.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.b.java.entities.Order;
import com.tobeto.spring.b.java.repostories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;



    @GetMapping
    public GetOrderListResponse getAll(){
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        return orderService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        orderService.add(addOrderRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateOrderRequest updateOrderRequest,@PathVariable int id){
        orderService.update(updateOrderRequest,id);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }

}
