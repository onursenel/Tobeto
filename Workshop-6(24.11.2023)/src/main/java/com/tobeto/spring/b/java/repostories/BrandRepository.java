package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


//Generic türler Reference Type olmak zorundadır =>Integer
public interface BrandRepository extends JpaRepository <Brand, Integer> {

}
