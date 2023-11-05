


package com.tobeto.spring.b.java;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductController {

    List <Product> inMemoryList = new ArrayList<>();

    @GetMapping//api/product
    public List<Product> get(){
        return inMemoryList;

    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id){
        Product product = inMemoryList.stream().filter((pro)->pro.getProductId() == id).findFirst().orElseThrow();
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        inMemoryList.add(product);
        return product;
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody Product product){
        Optional<Product> existingProduct = inMemoryList.stream().filter((pro)-> pro.getProductId() == id).findFirst();


        if(existingProduct.isPresent()){
            Product updateProduct = existingProduct.get();
            //updateProduct.setProductId(product.getProductId()); id genelde değiştirilmez oldugu için commandlendi
            updateProduct.setProductName(product.getProductName());
            updateProduct.setBrand(product.getBrand());
            updateProduct.setUnitPrice(product.getUnitPrice());
            updateProduct.setColor(product.getColor());
            updateProduct.setSize(product.getSize());
            updateProduct.setFeature(product.getFeature());
            return new ResponseEntity<>("Ürün güncellendi",HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Bu id'ye sahip ürün bulunamadı!!",HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("{id}")
    public Product deleteById(@PathVariable int id){
        Product product = inMemoryList.stream().filter((pro)->pro.getProductId() == id).findFirst().orElseThrow();
        inMemoryList.remove(product);
        return product;
    }


}


