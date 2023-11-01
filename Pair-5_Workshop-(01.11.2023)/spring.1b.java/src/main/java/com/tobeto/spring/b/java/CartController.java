package com.tobeto.spring.b.java;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cartcontrollers")
public class CartController {

    @GetMapping
    public String get(){
        return "Product is getting to cart";
    }

    @PostMapping
    public String post(){
        return "Product is add to cart";
    }

    @PutMapping
    public String put(){
        return "Product is update to cart";
    }

    @DeleteMapping
    public String delete(){
        return "Product is delete to cart";
    }

}
