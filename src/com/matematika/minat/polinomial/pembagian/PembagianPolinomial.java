package com.matematika.minat.polinomial.pembagian;

public class PembagianPolinomial {
    public static void main(String[] args) {
        // TODO Membuat kode pembagian polinomial
        // 1. Horner kino xd
        // pdf lihat di N:\Mapel\MTK\SEMESTER 2\MINAT\Pembagian_Polinomial.pdf
        
        // Contoh f(x) = 2x^4-6x^3+2x^2-1
        // konstanta = {2,-6,2,0,-1};

        int[] konstanta = Utility.getKonstanta(); // mengambil konstanta dari user
        int banyakKonstanta = konstanta.length;
        int x = Utility.getNumber("Masukkan pembagi"); // Masukkan pembagi. Contoh: (x - 3) = 0 ; 3
        Polinomial.Horner(konstanta, banyakKonstanta, x);

    }
}
