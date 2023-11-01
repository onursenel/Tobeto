package com.tobeto.spring.b.java;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")


public class PersonsContoller {

    @GetMapping
    public String get(){
        return "Person getting";
    }

    @PostMapping
    public String post(){
        return "Person add";
    }

    @PutMapping
    public String put(){
        return "Person update";
    }

    @DeleteMapping
    public String delete(){
        return "Person Delete";
    }



}
