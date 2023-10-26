import models.Category;
import models.Order;
import models.Product;
import models.User;

/*

Bir e-ticaret sitesi için aşağıdaki modelleri class haline getiriniz.
Encapsulation uygulayınız ve constructorlar oluşturunuz.
Bunları main dosyasında oluşturarak bir kaç örnek kullanım ekleyiniz.

Modellerimiz:
Category
Product
Order
User

*/
public class Main {
    public static void main(String[] args) {

        Category category1 = new Category("Ayakkabı","101");
        Category category2=new Category("Çanta","102");
        Category category3 = new Category("Pantolon","103");

        Product product1 = new Product("Nike",00001,3.500,99);
        Product product2 = new Product("Adidas",00002,2.500,65);
        Product product3 = new Product("Puma",00003,2.900,44);

        User user1 = new User("Onur","Senel","05551112233","İstanbul-BCEK",1);
        User user2 = new User("Süleyman","Hacıoglu","05554448899","İstanbul-GOP",2);
        User user3 = new User("Mertcan","Cobanoglu","05555551166","İstanbul-SLTNGZI",3);

        Order order1 = new Order("12345",12);
        Order order2 = new Order("33144",10);
        Order order3 = new Order("33144",10);

        //order'ları dizi içerisinde tanımlarken, String bir dizi tanımlaması yaptığımızdan get ile sadece string tipindeki verileri diziye atmamız gerekir.
        String[] orders = {order1.getOrderNumber(),order2.getOrderNumber(),order3.getOrderNumber()};

        order1.OrderDetails();//Order class'ı içerisinde yazmış olduğumuz fonksiyonu burada kullandık ve Order detaylarını ekrana bastırdık.

        System.out.println("***************** Bütün Sipariş Numaraları *****************");
        for (String orders1:orders // for-each yöntemi ile 39. satırdaki orderNumber'ların hepsini döndürüp ekrana basıyoruz.
             ) {
            System.out.println( orders1);

        }









    }
}