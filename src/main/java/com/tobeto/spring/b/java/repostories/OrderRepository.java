package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Order;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    //Derived Query Methods

    //tarih girilerek entity'den veri getiriliyor.
    List<Order> findByDate(LocalDate date);

    //tarih ya da id ile entity'den veri getiriliyor
    List<Order> findByDateOrId(LocalDate date,int id);

    @Query("Select new com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse(o.date,o.rentalStartDate,o.rentalEndDate) FROM Order o")
    List<GetOrderListResponse> getAll2();

    @Query("SELECT new com.tobeto.spring.b.java.services.dtos.responses.order.GetOrderListResponse(o.date) FROM Order o ORDER BY o.date")
    List<GetOrderListResponse> orderDate();

}
