package com.tobeto.spring.b.java.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "corporate_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CorporateInvoice {

    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "contact_name")
    private String contactName;

    @JoinColumn(name = "contact_address")
    private String contactAddress;

    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    @JoinColumn(name = "tax_number")
    private String taxNumber;

    @JoinColumn(name= "amount")
    private int amount;


    @OneToMany(mappedBy = "corporateInvoice")
    @JsonIgnore
    List<InvoiceDetail> invoiceDetails;


}
