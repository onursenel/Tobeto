package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.entities.Customers;
import com.tobeto.spring.b.java.repositories.ChassisNumberRepository;
import com.tobeto.spring.b.java.repositories.CustomersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomersRepository customersRepository;

    public CustomersController(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    @GetMapping
    public List<Customers> getAll(){
        return customersRepository.findAll();
    }

    @GetMapping("{id}")
    public Customers getById(@PathVariable int id){
        return customersRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customers customers){
        customersRepository.save(customers);

    }

    @PutMapping
    public void update(@RequestBody Customers customers){
        Customers customersToUpdate = customersRepository.findById(customers.getId()).orElseThrow();
        customersToUpdate.setName(customers.getName());
        customersToUpdate.setSurname(customers.getSurname());
        customersToUpdate.setAddress(customers.getAddress());
        customersToUpdate.setEmail(customers.getEmail());
        customersToUpdate.setPhone(customers.getPhone());
        customersRepository.save(customersToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customersRepository.deleteById(id);
    }

}
