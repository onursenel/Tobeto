package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.CustomerService;
import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerService customerService;



    @GetMapping("getAll")
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }


    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);

    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        customerService.add(addCustomerRequest);


    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest,@PathVariable int id){
        customerService.update(updateCustomerRequest,id);


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }


    @GetMapping("name")
    public List<GetCustomerListResponse> getByNameLike(@RequestParam String name){
        return customerService.getByNameLike(name);
    }

    @GetMapping("nameIgnoreCase")
    public List<GetCustomerListResponse> getNameIgnoreCase(@RequestParam String name){
        return customerService.getByNameIgnoreCase(name);
    }

    @GetMapping("JPQLSearchCustomerName")
    public List<GetCustomerListResponse> getSearchCustomerName(@RequestParam String name){
        return this.customerService.searchCustomerName(name);
    }

    @GetMapping("nameOrder")
    public List<GetCustomerListResponse> getOrderName(){
        return this.customerService.orderName();
    }






}
