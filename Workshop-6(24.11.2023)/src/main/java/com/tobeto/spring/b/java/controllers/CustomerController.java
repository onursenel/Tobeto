package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.CustomerService;
import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.repostories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;



    @GetMapping
    public GetCustomerListResponse getAll(){
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



}
