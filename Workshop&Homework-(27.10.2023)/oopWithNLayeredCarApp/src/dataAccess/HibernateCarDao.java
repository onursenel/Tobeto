package dataAccess;

import entities.Car;

public class HibernateCarDao implements CarDao{


    @Override
    public void add(Car car) {
        System.out.println("Hibernate Yöntemi ile veritabanına eklendi");
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(Car car) {

    }
}
