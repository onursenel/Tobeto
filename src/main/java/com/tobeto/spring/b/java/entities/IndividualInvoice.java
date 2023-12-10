package com.tobeto.spring.b.java.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "individual_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class IndividualInvoice {
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "surname")
    private String surname;

    @JoinColumn(name = "amount")
    private int amount;

    @JoinColumn(name = "address")
    private String address;

    @OneToMany(mappedBy = "individualInvoice")
    private List<InvoiceDetail> invoiceDetails;
}
