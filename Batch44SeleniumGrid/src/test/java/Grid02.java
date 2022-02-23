import java.util.Scanner;

public class Grid02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Kontrol edilecek sayiyi giriniz:");

        int sayi = scan.nextInt();

        int count=0;


        for (int i = 2; i <sayi ; i++) {

            if (sayi%i==0) count++;

        }

        if(count==0) System.out.println(sayi+" asaldir");
        else System.out.println("sayi asal degil");



    }


}
