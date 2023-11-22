package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.entities.ChassisNumber;
import com.tobeto.spring.b.java.repositories.ChassisNumberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chassis_number")
public class ChassisNumbersController {

    //Dependency => Bağımlılık
    // Injection => Enjekte
    private final ChassisNumberRepository chassisNumberRepository;
    //final => ctor blok dışında set edemezsin

    public ChassisNumbersController(ChassisNumberRepository chassisNumberRepository){
        this.chassisNumberRepository = chassisNumberRepository;
    }


    //Spring IoC  container


    @GetMapping
    public List<ChassisNumber> getAll() {
        return chassisNumberRepository.findAll();
    }
    @GetMapping("{id}")
    public ChassisNumber getById(@PathVariable int id){
        return chassisNumberRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@org.springframework.web.bind.annotation.RequestBody ChassisNumber chassisNumber){
        chassisNumberRepository.save(chassisNumber);
    }
    @PutMapping
    public void update(@RequestBody ChassisNumber chassisNumber) {
        ChassisNumber chassisNumberToUpdate = chassisNumberRepository.findById(chassisNumber.getId()).orElseThrow();
        chassisNumberToUpdate.setBrand(chassisNumber.getBrand());
        chassisNumberToUpdate.setModelYear(chassisNumber.getModelYear());
        chassisNumberToUpdate.setProductionPlace(chassisNumber.getProductionPlace());
        chassisNumberToUpdate.setType(chassisNumber.getType());
        chassisNumberToUpdate.setColor(chassisNumber.getColor());
        chassisNumberRepository.save(chassisNumberToUpdate);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        //ChassisNumber chassisNumberDelete = chassisNumberRepository.findById(id).orElseThrow();
        //kod buraya geliyorsa exception fırlamamıştır.
        //chassisNumberRepository.deleteById(chassisNumberDelete);
        chassisNumberRepository.deleteById(id);

    }





}
