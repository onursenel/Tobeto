package com.tobeto.spring.b.java.repositories;

import com.tobeto.spring.b.java.entities.ChassisNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChassisNumberRepository extends JpaRepository <ChassisNumber, Integer> {
}
