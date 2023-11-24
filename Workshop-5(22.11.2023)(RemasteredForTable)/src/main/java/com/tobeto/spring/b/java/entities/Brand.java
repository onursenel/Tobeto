
//REMASTERED (Chassis number adındaki tablo brands olarak revize edildi)

package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String name;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "production_place")
    private String productionPlace;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;


    @OneToMany(mappedBy = "brand")
    @JsonIgnore // bu alan jsona ignore edilirken yok sayılacak
    private List<Car> cars;


}
