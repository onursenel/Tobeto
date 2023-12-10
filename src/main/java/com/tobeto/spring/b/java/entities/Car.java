package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="cars")
@Entity
@Data // => @getter ve @setter ı getirir ikisini birlikte yapar
@AllArgsConstructor
@NoArgsConstructor

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
    @JoinColumn(name="brand_id")
    private Brand brand;


    @OneToMany(mappedBy = "carId")
    @JsonIgnore
    private List<Order> orders;

}
