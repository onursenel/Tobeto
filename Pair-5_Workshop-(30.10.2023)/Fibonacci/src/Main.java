
public class Main {
    public static void main(String[] args) {

        int n1=0,n2=1,n3,i,n=100;
        System.out.print(n1+" "+n2);//0 ve 1 yazdır

        for(i=2;i<n;++i)//Döngü 2 den başlıyor çünkü ilk 2 terim 0 ve 1 her zaman yazılacak
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
        System.out.println();
    }
}