package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.CarService;
import com.tobeto.spring.b.java.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {

    private final CarService carService;



    @GetMapping("getAll")
    public List<GetCarListResponse> getAll(){
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

    @GetMapping("getAll2")
    public List<GetCarListResponse> getAll2(){
        return carService.getAll2();
    }


    @GetMapping("plateOrId")
    public List<GetCarListResponse> getPlateOrEqualsId(@RequestParam String plate,@RequestParam int id){
        return carService.getPlateOrEqualsId(plate,id);
    }

    @GetMapping("rentalFee")
    public List<GetCarListResponse> getByRentalFee(@RequestParam int rentalFee){
        return carService.getByRentalFee(rentalFee);
    }

    @GetMapping("orderRentalFee")
    public List<GetCarListResponse> getOrderRentalFee(){
        return carService.getOrderRentalFee();
    }






}
