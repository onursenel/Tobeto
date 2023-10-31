import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bir sayı giriniz : ");
        int number = scanner.nextInt(); //
        int num1 = number;
        int num2 = number;



        int numberOfDigits = 0;
        int total = 0;
        int rakam;

        while(num1 > 0 ){ //Bu döngüde basamak sayısını buluyoruz.
            num1 = num1 /10 ;
            numberOfDigits++;
        }
        while(number > 0){
            rakam = number %10 ;
            total +=Math.pow(rakam,numberOfDigits); // üs alma methodu.
            number /=10;
        }

        if(total == num2){
            System.out.println(num2 + "bir armstrong sayısıdır");
        }
        else{
            System.out.println(num2 + " sayısı bir armstrong sayısı değildir!!!");
        }

    }
}