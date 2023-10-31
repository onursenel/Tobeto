import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Kelimeyi girin : ");
        String anagram1 = scanner.nextLine();

        System.out.println("2.kelimeyi girin : ");
        String anagram2= scanner.nextLine();


        String a =anagram1.toLowerCase(); //kullanıcıdan alınan kelimeniyi küçülterek a değişkenine atamak
        String b =anagram2.toLowerCase(); //kullanıcıdan alınan kelimeniyi küçülterek b değişkenine atamak


        char[] a1 = a.toCharArray(); //Gelen string ifadeyi char dizisine atama
        char[] a2 = b.toCharArray();



        Arrays.sort(a1); //atanılan dizi ifadelerini sıraya sokma
        Arrays.sort(a2);


        boolean esitMi=Arrays.equals(a1,a2);



        if(esitMi){ //true ise
            System.out.println("anagramdır");
        }
        else { //aksi durumda
            System.out.println("anagram degıldır!!");
        }






    }
}