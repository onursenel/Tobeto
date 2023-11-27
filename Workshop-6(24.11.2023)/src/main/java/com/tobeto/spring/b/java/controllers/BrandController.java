



package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.java.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandController {


    private final BrandService brandService;

    @GetMapping
    public GetBrandListResponse getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")

    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        brandService.add(addBrandRequest);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest,@PathVariable int id) {
        brandService.update(updateBrandRequest,id);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }


}

