package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.repostories.CarRepository;
import com.tobeto.spring.b.java.services.abstracts.CarService;
import com.tobeto.spring.b.java.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service

public class CarManager implements CarService {


    private final CarRepository carRepository;



    @Override
    public GetCarListResponse getAll() {
        GetCarListResponse carList = new GetCarListResponse();
        carList.setCars(carRepository.findAll());
        return carList;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse carDto = new GetCarResponse();
        carDto.setPlate(car.getPlate());
        carDto.setRentalFee(car.getRentalFee());

        return carDto;
    }


    @Override
    public void add(AddCarRequest addCarRequest) {
        if(addCarRequest.getRentalFee() <1000){
            throw new RuntimeException("aracın kiralama ücreti 1000 tl den az olamaz !");
        }
        else if(addCarRequest.getPlate().length() < 9 ){
            throw new RuntimeException("Plakayı eksik girdiniz!!");
        }
        Car car =new Car();

        car.setPlate(addCarRequest.getPlate());
        car.setRentalFee(addCarRequest.getRentalFee());

        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest, int id) {
        Car car = carRepository.findById(id).orElseThrow();

        car.setPlate(updateCarRequest.getPlate());
        car.setRentalFee(updateCarRequest.getRentalFee());

        carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);

    }
}
