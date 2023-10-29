package business;

import core.logging.Logger;
import dataAccess.CarDao;
import entities.Car;

public class CarManager {
    private CarDao carDao;
    private Logger[] loggers;

    public CarManager(CarDao carDao,Logger[] loggers) {
        this.carDao = carDao;
        this.loggers=loggers;
    }

    public void delete(Car car) throws Exception {

        if(car.getYearOfProduction() > 2005){
            throw new Exception("2005 den büyük araçlar silinemez");
        }

        carDao.delete(car);
        System.out.println(car.getYearOfProduction() + " yılında üretilmiş olan araç silindi!!");


    }

    public void add(Car car) throws Exception {
        if(car.getUnitPrice()<100000){
            throw new Exception("Aracın Fiyatı 100.000 Tl den az olamaz !!! ");
        }


        carDao.add(car);
        for (Logger logger: loggers) {
            logger.log(car.getBrand());

        }

    }

    public void update(Car car){
        if(car.getColor() == "White"){
            System.out.println("Beyaz olan araçları güncelleme yetkiniz bulunmuyor!!!");
        }
        carDao.update(car);

    }
}
