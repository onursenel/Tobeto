



package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.java.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.java.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {


    private final BrandService brandService;


    @GetMapping("getAll")
    public List<GetBrandListResponse> getAll(){
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
    @GetMapping("nameOrId")
    public List<GetBrandListResponse> getByNameOrId(@RequestParam String name, @RequestParam int id){
        return this.brandService.getByNameOrId(name,id);
    }

    @GetMapping("name")
    public List<GetBrandListResponse> getByName(@RequestParam String name){
        return this.brandService.getByName(name);
    }

    @GetMapping("nameIgnoreCase")
    public List<GetBrandListResponse> getByNameIgnoreCase(@RequestParam String name){
        return this.brandService.getByNameIgnoreCase(name);
    }

    @GetMapping("search")
    public List<GetBrandListResponse> search(@RequestParam String name){
        return brandService.search(name);
    }

    @GetMapping("orderAllList")
    public List<GetBrandListResponse> order(){
        return brandService.order();
    }







}

