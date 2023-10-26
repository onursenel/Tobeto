import business.ProductManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateProductDao;
import dataAccess.JdbcProductDao;
import entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};




        Product product1 = new Product(1,"Iphone 13",30000);

        ProductManager productManager = new ProductManager(new HibernateProductDao(),loggers);
        productManager.add(product1);


    }
}