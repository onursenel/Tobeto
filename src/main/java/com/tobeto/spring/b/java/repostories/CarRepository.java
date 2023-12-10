package com.tobeto.spring.b.java.repostories;

import com.tobeto.spring.b.java.entities.Car;
import com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository <Car,Integer>{

    //Derived Query Methods

    //plaka ya da id ile car entitysinden veri çekmek
    List<Car> findByPlateLikeOrIdEquals(String plate,int id);

    //Kiralama ücreti ile car entitysinden veri çekmek
    List<Car> findByRentalFee(int rentalFee);

    //JPQL

    //Bütün verilerin getirilmesi
    @Query("select new com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse(c.id,c.plate,c.rentalFee, new com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse(b.name)) from Car c INNER JOIN c.brand b")
    List<GetCarListResponse> getAll2();


    //Bütün verilerimizi rentalFee ile sıraya sokarak sıralama işlemi yapıldı.
    @Query("select new com.tobeto.spring.b.java.services.dtos.responses.car.GetCarListResponse(c.id,c.plate,c.rentalFee, new com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse(b.name)) from Car c INNER JOIN c.brand b Order by c.rentalFee")
    List<GetCarListResponse> getOrderRentalFee();


}
