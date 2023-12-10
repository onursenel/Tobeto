package com.tobeto.spring.b.java.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "invoice_details")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceDetail {
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "corporate_invoice_id")
    private CorporateInvoice corporateInvoice;

    @ManyToOne
    @JoinColumn(name = "individual_invoice_id")
    private IndividualInvoice individualInvoice;

    @OneToMany(mappedBy = "invoiceDetail")
    private List<Order> orders;



}
