package Proje5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {
        Random sayi = new Random();
        int number = sayi.nextInt(100);

        //int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int hak = 0;
        int giris;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        System.out.println(number);

        while (hak < 5) {
            System.out.println("Tahmininizi giriniz (0-100) : ");
            giris = input.nextInt();

            if (giris < 0 || giris > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz ");
                if (!isWrong) {
                    isWrong = true;
                    System.out.println("Tekrar hatalı girişinizde hakkınızdan düşülecektir ");
                } else {
                    hak++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - hak));
                }
                continue;
            }
            if (giris == number) {
                System.out.println("Tebrikler doğru tahmin ");
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz ");
                if (giris > number) {
                    System.out.println("Girdiğiniz sayı random sayıdan büyüktür. Lütfen daha küçük değer girin");
                } else {
                    System.out.println("Girdiğiniz sayı random sayıdan küçüktür. Lütfen daha büyük değer girin ");
                }
                wrong[hak] = giris;
                hak++;
                System.out.println("Kalan hak : " + (5 - hak));
            }
        }
        if (!isWin) {
            System.out.println("Kaybettiniz.");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }
    }
}
