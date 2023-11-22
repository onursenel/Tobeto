package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="chassis_number")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChassisNumber {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "production_place")
    private String productionPlace;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;


    @OneToMany(mappedBy = "chassisNumber")
    @JsonIgnore // bu alan jsona ignore edilirken yok sayılacak
    private List<Cars> cars;


}
