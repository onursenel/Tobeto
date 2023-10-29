import business.CarManager;
import core.logging.DataBaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateCarDao;
import dataAccess.JdbcCarDao;
import entities.Car;

public class Main {
    public static void main(String[] args) throws Exception {


        Car car1 = new Car(11111,"BMW","RED","Hatch back",2004,800000);
        Car car2 = new Car(22222,"Mercedes","Black","Hatch back",2019,1500000);
        Car car3 = new Car(33333,"VW","White","Hatch back",2020,1150000);


        Logger[] loggers = {new MailLogger(),new DataBaseLogger(),new FileLogger()};

        CarManager carManager = new CarManager(new JdbcCarDao(),loggers);



        carManager.add(car1);
        carManager.delete(car1);
        carManager.update(car3);












    }
}