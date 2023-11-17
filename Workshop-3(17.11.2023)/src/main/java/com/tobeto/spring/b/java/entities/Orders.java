package com.tobeto.spring.b.java.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Table(name="orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="date")
    private LocalDate date;

    @Column(name = "rental_start_date")
    private LocalDate rentalStartDate;

    @Column(name = "rental_end_date")
    private LocalDate rentalEndDate;

    //ManyToOne

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customerId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car carId;
}
