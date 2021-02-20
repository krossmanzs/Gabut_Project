package com.matematika.minat.polinomial.pembagian;

import java.util.Scanner;

public class Utility {
    private static Scanner input = new Scanner(System.in);
    private static int[] konstanta;

    static int[] getKonstanta(){
        System.out.print("Masukkan jumlah konstanta: ");
        int jumlahKonstanta = input.nextInt();

        konstanta = new int[jumlahKonstanta];
        for(int i = 0; i < jumlahKonstanta; i++){
            System.out.print("Masukkan konstanta ke-" + i + ": ");
            konstanta[i] = input.nextInt();
        }
        return konstanta;
    }

    static int getNumber(String message){
        System.out.print(message + ": ");
        return input.nextInt();
    }
}
