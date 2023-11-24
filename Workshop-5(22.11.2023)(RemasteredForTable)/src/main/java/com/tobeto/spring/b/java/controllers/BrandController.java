



package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.java.entities.Brand;
import org.springframework.web.bind.annotation.*;
import com.tobeto.spring.b.java.repostories.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public GetBrandListResponse getAll() {
        GetBrandListResponse brandList = new GetBrandListResponse();
        brandList.setBrands(brandRepository.findAll());
        return brandList;
    }

    @GetMapping("{id}")

    public GetBrandResponse getById(@PathVariable int id){

        Brand brand = brandRepository.findById(id).orElseThrow();

        //Mapping
        GetBrandResponse brandDto = new GetBrandResponse();
        brandDto.setName(brand.getName());
        brandDto.setModel_year(brand.getModelYear());
        //dto.setProduction_place(brand.getProductionPlace());
        brandDto.setType(brand.getType());
        brandDto.setColor(brand.getColor());


        return brandDto;
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        Brand brand = new Brand();


        //Mapping
        brand.setName(addBrandRequest.getName());
        brand.setModelYear(addBrandRequest.getModel_year());
        brand.setProductionPlace(addBrandRequest.getProduction_place());
        brand.setType(addBrandRequest.getType());
        brand.setColor(addBrandRequest.getColor());
        brandRepository.save(brand);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest,@PathVariable int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        brand.setName(updateBrandRequest.getName());
        brand.setModelYear(updateBrandRequest.getModelYear());
        brand.setProductionPlace(updateBrandRequest.getProductionPlace());
        brand.setType(updateBrandRequest.getType());
        brand.setColor(updateBrandRequest.getColor());
        brandRepository.save(brand);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        brandRepository.deleteById(id);
    }


}

