package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Car,Integer>{
}
