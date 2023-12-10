package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "payment_methods")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentMethod {
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "type")
    private String type;

    @JoinColumn(name = "credit_card_information")
    private String creditCardInformation;

    @JoinColumn(name = "money_type")
    private String moneyType;

    @OneToMany(mappedBy = "paymentMethod")
    @JsonIgnore
    private List<PaymentDetail> paymentDetails;


}
