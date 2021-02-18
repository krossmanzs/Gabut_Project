package com.matematika.minat.polinomial.pembagian;

class Polinomial{
    private static String bentukFx(int[] konstantaHasil, int panjangKonstanta){
        // inisialisasi string
        StringBuilder fx = new StringBuilder();

        for(int i = 0; i < panjangKonstanta; i++){
            if((konstantaHasil[i] != 0) && (konstantaHasil[i] < 0)){
                fx.append(konstantaHasil[i]);
            } else if ((konstantaHasil[i] != 0) && (konstantaHasil[i] > 0)){
                if (i != 0) {
                    fx.append("+");
                }
                fx.append(konstantaHasil[i]);
            }

            if(konstantaHasil[i] == 0){
                continue;
            }

            if(i < panjangKonstanta-2){
                fx.append("x^").append(panjangKonstanta - (i+1));
            } else if(i == panjangKonstanta - 2){
                fx.append("x");
            }
        }

        return fx.toString();
    }

    static void Horner(int[] konstanta, int banyakKonstanta, int x){
        // inisialisasi hasil
        int sisa = konstanta[0];
        int[] hasil = new int[banyakKonstanta-1];

        hasil[0] = konstanta[0];

        // menghitung
        for (int i = 1; i < banyakKonstanta; i++){
            sisa = (sisa * x) + konstanta[i];
            if(i < banyakKonstanta - 1){
                hasil[i] = sisa;
            }
        }

        System.out.println("Hasil: " + bentukFx(hasil,hasil.length));
        System.out.println("Sisa: " + sisa);
    }
}

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
