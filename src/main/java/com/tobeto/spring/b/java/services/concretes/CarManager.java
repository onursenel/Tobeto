package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.Brand;
import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.repostories.CarRepository;
import com.tobeto.spring.b.java.services.abstracts.CarService;
import com.tobeto.spring.b.java.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service

public class CarManager implements CarService {


    private final CarRepository carRepository;


    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> getCarListResponseList = new ArrayList<>();

        for (Car car: cars) {
            GetCarListResponse response = new GetCarListResponse();
            response.setId(car.getId());
            response.setPlate(car.getPlate());
            response.setRentalFee(car.getRentalFee());
            getCarListResponseList.add(response);
        }
        return getCarListResponseList;
    }


    @Override
    public List<GetCarListResponse> getPlateOrEqualsId(String plate, int id) {
        List<Car> cars = carRepository.findByPlateLikeOrIdEquals("%"+plate+"%",id);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car:cars) {
            Brand brand = new Brand();
            response.add(new GetCarListResponse(car.getId(),car.getPlate(),car.getRentalFee(),new GetBrandListResponse(brand.getName())));

        }
        return response;
    }

    @Override
    public List<GetCarListResponse> getByRentalFee(int rentalFee) {
        List<Car> cars = carRepository.findByRentalFee(rentalFee);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car:cars) {
            Brand brand = new Brand();
            response.add(new GetCarListResponse(car.getId(),car.getPlate(),car.getRentalFee(),new GetBrandListResponse(brand.getName())));

        }
        return response;
    }

    @Override
    public List<GetCarListResponse> getOrderRentalFee() {
        return carRepository.getOrderRentalFee();
    }



    @Override
    public List<GetCarListResponse> getAll2() {
        return carRepository.getAll2();
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
