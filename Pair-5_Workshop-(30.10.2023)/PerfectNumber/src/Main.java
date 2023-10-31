import java.util.Scanner;

public class Main {
    public static boolean isPerfectNumber(long num) {  // Bölenlerinin toplamı, sayıya eşitse yazan fonksiyon
        long total = 0;
        for (long i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                total += i;
            }
        }
        return total == num;
    }

    public static void main(String[] args) {
        long limit = 10000000000000L; //Döngünün üst limiti

        System.out.println("Mükemmel Sayılar: ");
        for (long num = 1; num <= limit; num++) {
            if (isPerfectNumber(num)) {
                System.out.println(num);
            }
        }
    }
}