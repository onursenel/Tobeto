package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor




public class Cars {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name="plate")
    private String plate;

    @Column(name="rental_fee")
    private int rentalFee;


    @ManyToOne
    @JoinColumn(name="chassis_number_id")
    private ChassisNumber chassisNumber;


    @OneToMany(mappedBy = "carId")
    @JsonIgnore
    private List<Orders> orders;




}
