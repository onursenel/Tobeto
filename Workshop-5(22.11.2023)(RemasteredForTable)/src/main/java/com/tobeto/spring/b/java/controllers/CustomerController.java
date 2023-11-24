package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.repostories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;

    }


    @GetMapping
    public GetCustomerListResponse getAll(){
        GetCustomerListResponse customerList = new GetCustomerListResponse();
        customerList.setCustomers(customerRepository.findAll());
        return customerList;
    }


    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse customerDto = new GetCustomerResponse();
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());


        return customerDto;



    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        Customer customer = new Customer();

        customer.setName(addCustomerRequest.getName());
        customer.setSurname(addCustomerRequest.getSurname());
        customer.setAddress(addCustomerRequest.getAddress());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPhone(addCustomerRequest.getPhone());

        customerRepository.save(customer);


    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest,@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setPhone(updateCustomerRequest.getPhone());

        customerRepository.save(customer);


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }



}
