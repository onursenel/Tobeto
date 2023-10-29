package dataAccess;

import entities.Car;

public class JdbcCarDao implements CarDao{


    @Override
    public void add(Car car) {
        System.out.println("JDBC Yöntemi ile veritabanına eklendi");
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(Car car) {

    }
}
