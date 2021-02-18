package com.matematika.minat.polinomial.pembagian;

public class PembagianPolinomial {
    public static void main(String[] args) {
        // TODO Membuat kode pembagian polinomial
        // 1. Horner kino xd
        // pdf lihat di N:\Mapel\MTK\SEMESTER 2\MINAT\Pembagian_Polinomial.pdf

        int[] konstanta = {2,-6,2,0,-1};
        int banyakKonstanta = konstanta.length;
        int x = 3;
        Polinomial.Horner(konstanta, banyakKonstanta, x);

    }
}
