

package com.tobeto.spring.b.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/category")

public class CategoryController {

    List<Category> inMemoryList = new ArrayList<>();

    @GetMapping
    public List<Category> get(){
        return inMemoryList; // in memorylist içersindeki bütük elemanları getirme
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id){
        Category category = inMemoryList.stream().filter((cat)-> cat.getCategoryId() == id).findFirst().orElseThrow();
        return category;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        inMemoryList.add(category);
        return category;
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody Category category){
        Optional<Category> existingCategory = inMemoryList.stream().filter((cat)-> cat.getCategoryId() == id).findFirst();

        if(existingCategory.isPresent()){
            Category updateCategory = existingCategory.get();
            //updateCategory.setCategoryId(category.getCategoryId());
            updateCategory.setCategoryName(category.getCategoryName());
            updateCategory.setGender(category.getGender());
            return new ResponseEntity<>("Category Güncellendi!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Bu id'ye ait bir Category bulunamadı",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public Category deleteById(@PathVariable int id){
        Category category = inMemoryList.stream().filter((cat)-> cat.getCategoryId() == id).findFirst().orElseThrow();
        inMemoryList.remove(category);
        return category;

    }


}
