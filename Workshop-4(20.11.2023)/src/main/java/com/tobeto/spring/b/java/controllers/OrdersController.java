package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.entities.Orders;
import com.tobeto.spring.b.java.repositories.OrdersRepositories;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {


    private final OrdersRepositories ordersRepositories;


    public OrdersController(OrdersRepositories ordersRepositories){
        this.ordersRepositories=ordersRepositories;
    }

    @GetMapping
    public List<Orders> getAll(){
        return ordersRepositories.findAll();

    }

    @GetMapping("{id}")
    public Orders getById(@PathVariable int id){
        return ordersRepositories.findById(id).orElseThrow();

    }

    @PostMapping
    public void add(@RequestBody Orders orders){
        ordersRepositories.save(orders);
    }

    @PutMapping
    public void update(@RequestBody Orders orders){
        Orders ordersToUpdate = ordersRepositories.findById(orders.getId()).orElseThrow();
        ordersToUpdate.setDate(orders.getDate());
        ordersToUpdate.setRentalStartDate(orders.getRentalStartDate());
        ordersToUpdate.setRentalEndDate(orders.getRentalEndDate());

        ordersRepositories.save(ordersToUpdate);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        ordersRepositories.deleteById(id);
    }

}
