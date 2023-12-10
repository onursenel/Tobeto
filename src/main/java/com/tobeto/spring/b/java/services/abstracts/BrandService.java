package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetBrandListResponse> getByNameOrId(String name, int id);
    List<GetBrandListResponse> getByName(String name);
    List<GetBrandListResponse> getByNameIgnoreCase(String name);

    List<GetBrandListResponse> search(String name);

    List<GetBrandListResponse> order();


    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest,int id);
    void delete(int id);
}
