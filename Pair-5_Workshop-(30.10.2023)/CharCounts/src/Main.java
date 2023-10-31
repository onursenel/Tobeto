import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {





        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin giriniz: ");
        String str = scanner.nextLine();
        String str2= str.toLowerCase(); //Girilen kelimenin harflerini küçültme


        HashMap<Character, Integer> charCounts = new HashMap<>();// Hashmap metodu ile karakter-değer ataması yapılır

        for (char c : str2.toCharArray()) {//dizi haline döndürülür
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1); //Bir harfin kaç defa olduğunu sayar ve atama işlemi yapar
        }

        for (char c : charCounts.keySet()) {//HashMap içerisine eklemiş olduğumuz anahtarları küme halinde geriye döndürür.
            System.out.println(c + ": " + charCounts.get(c)); //Ekran çıktısı olarak döner
        }

    }


}