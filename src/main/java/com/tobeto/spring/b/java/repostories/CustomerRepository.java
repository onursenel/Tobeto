package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    //Derived Query Methods
    List<Customer> findByNameLike(String name);
    List<Customer> findByNameIgnoreCase(String name);


    //JPQL
    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse(c.id,c.name,c.surname,c.address,c.email,c.phone) FROM Customer c Where c.name LIKE %:name%")
    List<GetCustomerListResponse> search(String name);


    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse(c.id,c.name,c.surname,c.address,c.email,c.phone) FROM Customer c ORDER BY c.name")
    List<GetCustomerListResponse> orderName();
}
