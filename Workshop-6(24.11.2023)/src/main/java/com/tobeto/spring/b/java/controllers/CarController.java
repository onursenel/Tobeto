package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.CarService;
import com.tobeto.spring.b.java.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.repostories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarController {

    private final CarService carService;



    @GetMapping
    public GetCarListResponse getAll(){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest){
        carService.add(addCarRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCarRequest updateCarRequest ,@PathVariable int id){
        carService.update(updateCarRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }




}
