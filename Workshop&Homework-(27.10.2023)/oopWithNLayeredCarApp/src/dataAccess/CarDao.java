package dataAccess;

import entities.Car;

public interface CarDao {
    void add(Car car);
    void update(Car car);

    void delete(Car chassisNumber);
}
