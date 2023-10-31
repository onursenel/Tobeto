
import java.util.Scanner;

public class Main {

    public static int getAmicable(int n) { //Bir sayının tam bölenlerinin toplamını döndüren fonksiyon
        int total = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                total += i;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 2000; i++) {//1 ile 2000 sayıları arasındaki döngüyü kurduk
            int amicable = getAmicable(i);//yukarıdaki fonksiyona gönderilen kod satırı
            if (amicable > i && amicable <= 2000 && getAmicable(amicable) == i) { //Arkadaş olan ilk iki sayıyı verme koşulu
                System.out.println(i + " sayısı ile " + amicable + " sayısı birbirinin dostudur.");
            }
        }
    }
}

