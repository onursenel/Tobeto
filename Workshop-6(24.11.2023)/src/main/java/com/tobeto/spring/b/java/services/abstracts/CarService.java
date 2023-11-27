package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.java.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarResponse;

public interface CarService {
    GetCarListResponse getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest addCarRequest);
    void update(UpdateCarRequest updateCarRequest,int id);
    void delete(int id);
}
