package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Brand;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//Generic türler Reference Type olmak zorundadır =>Integer
public interface BrandRepository extends JpaRepository <Brand, Integer> {
    //Derived Query Methods
    List<Brand> findByNameLikeOrIdEquals(String name, int id);
    List<Brand> findByName(String name);
    List<Brand> findByNameIgnoreCase(String name);



    //JPQL
    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse(b.name) FROM Brand b Where b.name LIKE %:name%")
    List<GetBrandListResponse> search(String name);


    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse(b.name) FROM Brand b ORDER BY b.name")
    List<GetBrandListResponse> order();



}
