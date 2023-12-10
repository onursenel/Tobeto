package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.IndividualInvoice;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualInvoiceRepository extends JpaRepository<IndividualInvoice,Integer> {

    //Derived Query Methods
    List<IndividualInvoice> findByNameLike(String name);
    List<IndividualInvoice> findByAddress(String address);


    //JPQL
    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse(i.name,i.surname,i.amount) FROM IndividualInvoice i Where i.name LIKE %:name%")
    List<GetIndividualInvoiceListResponse> searchName(String name);

    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse(i.name,i.surname,i.amount) FROM IndividualInvoice i ORDER BY i.amount")
    List<GetIndividualInvoiceListResponse> orderAmount();

}
