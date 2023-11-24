package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.repostories.CarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private final CarRepository carRepository;

    CarController(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    @GetMapping
    public GetCarListResponse getAll(){
        GetCarListResponse carList = new GetCarListResponse();
        carList.setCars(carRepository.findAll());
        return carList;

    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse carDto = new GetCarResponse();
        carDto.setPlate(car.getPlate());
        carDto.setRentalFee(car.getRentalFee());

        return carDto;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest){
        Car car =new Car();

        car.setPlate(addCarRequest.getPlate());
        car.setRentalFee(addCarRequest.getRentalFee());

        carRepository.save(car);

    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCarRequest updateCarRequest ,@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();

        car.setPlate(updateCarRequest.getPlate());
        car.setRentalFee(updateCarRequest.getRentalFee());

        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }




}
