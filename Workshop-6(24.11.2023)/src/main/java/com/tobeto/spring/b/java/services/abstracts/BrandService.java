package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandResponse;

public interface BrandService {

    GetBrandListResponse getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest,int id);
    void delete(int id);
}
