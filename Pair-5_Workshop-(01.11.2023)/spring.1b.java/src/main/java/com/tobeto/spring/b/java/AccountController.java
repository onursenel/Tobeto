package com.tobeto.spring.b.java;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")

public class AccountController {

    @GetMapping
    public String get(){
        return "Account getting";
    }

    @PostMapping
    public String post(){
        return "Account add";
    }
    @PutMapping
    public String put(){

        return "Acount update";

    }
    @DeleteMapping
    public String delete(){
        return "Account delete";
    }

}
