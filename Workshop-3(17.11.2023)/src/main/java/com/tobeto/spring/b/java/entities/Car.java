package com.tobeto.spring.b.java.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name="cars")
@Entity

public class Car {

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
    private List<Orders> orders;




}
