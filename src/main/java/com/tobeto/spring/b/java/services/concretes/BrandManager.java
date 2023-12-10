package com.tobeto.spring.b.java.services.concretes;


import com.tobeto.spring.b.java.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.java.entities.Brand;
import com.tobeto.spring.b.java.repostories.BrandRepository;
import com.tobeto.spring.b.java.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service

public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<GetBrandListResponse> getByNameOrId(String name, int id) {
        List<Brand> brands = brandRepository.findByNameLikeOrIdEquals("%"+name+"%",id);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand : brands){
            response.add(new GetBrandListResponse(brand.getName()));

        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> getByName(String name) {
        List<Brand> brands = brandRepository.findByName(name);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand:brands){
            response.add(new GetBrandListResponse(brand.getName()));
        }

        return response;
    }

    @Override
    public List<GetBrandListResponse> getByNameIgnoreCase(String name) {
        List<Brand> brands = brandRepository.findByNameIgnoreCase(name);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand:brands) {
            response.add(new GetBrandListResponse(brand.getName()));

        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> search(String name) {
        return brandRepository.search(name);
    }

    @Override
    public List<GetBrandListResponse> order() {
        return brandRepository.order();
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponseList = new ArrayList<>();

        for (Brand brand:brands) {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setName(brand.getName());
            getBrandListResponseList.add(response);

        }
        return getBrandListResponseList;

    }


    @Override
    public GetBrandResponse getById(int id) {

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

    @Override
    public void add(AddBrandRequest addBrandRequest) {
        if(addBrandRequest.getName().length() < 2 ){
            throw new RuntimeException("Marka adı 2 harften az olamaz!!");
        }
        else if(addBrandRequest.getModelYear()< 2000){
            throw new RuntimeException("Aracın model yılı 2000'den az olamaz!");
        }


        Brand brand = new Brand();


        //Mapping
        brand.setName(addBrandRequest.getName());
        brand.setModelYear(addBrandRequest.getModelYear());
        brand.setProductionPlace(addBrandRequest.getProductionPlace());
        brand.setType(addBrandRequest.getType());
        brand.setColor(addBrandRequest.getColor());
        brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, int id) {


        Brand brand = brandRepository.findById(id).orElseThrow();

        brand.setName(updateBrandRequest.getName());
        brand.setModelYear(updateBrandRequest.getModelYear());
        brand.setProductionPlace(updateBrandRequest.getProductionPlace());
        brand.setType(updateBrandRequest.getType());
        brand.setColor(updateBrandRequest.getColor());
        brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);

    }

}
