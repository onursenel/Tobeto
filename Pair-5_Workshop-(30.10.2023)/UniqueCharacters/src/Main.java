import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Cümle giriniz : ");
        String exp= scanner.nextLine();


        String exp1 = exp.replaceAll("\\s","");//String ifadedeki boşlukları kaldırır
        boolean result = UniqueCharacters.hasUniqueChar(exp1);

        if (result) {
            System.out.println("Tüm karakterler benzersiz.");
        } else {
            System.out.println("String tekrar eden karakterler içeriyor.");
        }




    }
}