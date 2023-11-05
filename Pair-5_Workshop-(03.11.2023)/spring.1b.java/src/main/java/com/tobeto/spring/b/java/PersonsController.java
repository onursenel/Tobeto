package com.tobeto.spring.b.java;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/persons")


public class PersonsController {
    List<Person> inMemoryList = new ArrayList<>();
    // In Memory DB
    // CRUD => Create,Read,Update,Delete


    @GetMapping // api/persons
    public List<Person> get(){
        return inMemoryList;
    }
    //@GetMapping("getById")
    // query string, path variable
    // path => https://localhost:8080/api/persons/30/halit/19
    // query string => https://localhost:8080/api/persons/getById?id=1&name=halit&age=19
    @GetMapping("{id}")
    public Person getById(@PathVariable int id){

        Person person = inMemoryList.stream().filter((per) -> per.getId() == id).findFirst().orElseThrow();
        return person;
    }


    @PostMapping
    public Person addPerson(@RequestBody Person person)
    {
        inMemoryList.add(person);
        return person;
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id,@RequestBody Person person){
        Optional<Person> existingPerson = inMemoryList.stream().filter((pro) -> pro.getId() == id).findFirst();

        if(existingPerson.isPresent()){
            Person updatePerson = existingPerson.get();
            //updatePerson.setId(updatePerson.getId()); id genelde değiştirilmez oldugu için commandlendi
            updatePerson.setName(person.getName());
            updatePerson.setSurname(person.getSurname());
            updatePerson.setAge(person.getAge());
            updatePerson.setGender(person.getGender());
            return new ResponseEntity<>("Person güncellendi ", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Bu id'ye ait bir person yoktur!",HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("{id}")
    public Person deleteById(@PathVariable int id){
        Person person = inMemoryList.stream().filter((per) -> per.getId() == id).findFirst().orElseThrow();
        inMemoryList.remove(person);
        return person;
    }




}
