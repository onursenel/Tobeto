package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.entities.Cars;
import com.tobeto.spring.b.java.repositories.CarRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepositories carRepositories;


    public CarsController(CarRepositories carRepositories){
        this.carRepositories = carRepositories;
    }

    @GetMapping
    public List<Cars> getAll(){
        return carRepositories.findAll();
    }

    @GetMapping("{id}")
    public Cars getById(@PathVariable int id){
        return carRepositories.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Cars cars){
        carRepositories.save(cars);
    }

    @PutMapping
    public void update(@RequestBody Cars cars){
        Cars carsToUpdate = carRepositories.findById(cars.getId()).orElseThrow();
        carsToUpdate.setPlate(cars.getPlate());
        carsToUpdate.setRentalFee(cars.getRentalFee());

        carRepositories.save(carsToUpdate);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepositories.deleteById(id);

    }



}
