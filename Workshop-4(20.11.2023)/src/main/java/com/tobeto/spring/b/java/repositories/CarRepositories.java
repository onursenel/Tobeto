package com.tobeto.spring.b.java.repositories;

import com.tobeto.spring.b.java.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepositories extends JpaRepository <Cars, Integer> {
}
