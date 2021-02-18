package com.matematika.minat.polinomial.pembagian;

public class Polinomial {
    private static String bentukFx(int[] konstantaHasil, int panjangKonstanta){
        // inisialisasi string
        StringBuilder fx = new StringBuilder();

        // membentuk fungsi f(x) nya
        for(int i = 0; i < panjangKonstanta; i++){
            if((konstantaHasil[i] != 0) && (konstantaHasil[i] < 0)){
                fx.append(konstantaHasil[i]);
            } else if ((konstantaHasil[i] != 0) && (konstantaHasil[i] > 0)){
                if (i != 0) { // mencegah konstanta pertama memiliki "+"
                    fx.append("+");
                }
                fx.append(konstantaHasil[i]);
            }

            // jika konstanta bernilai 0 maka akan di skip
            if(konstantaHasil[i] == 0){
                continue;
            }

            // pengkondisian untuk memberikan x nya
            if(i < panjangKonstanta-2){
                fx.append("x^").append(panjangKonstanta - (i+1));
            } else if(i == panjangKonstanta - 2){
                fx.append("x");
            }
        }

        // mengubah fx menjadi string dan me return
        return fx.toString();
    }

    static void Horner(int[] konstanta, int banyakKonstanta, int x){
        // inisialisasi hasil
        int sisa = konstanta[0];
        int[] hasil = new int[banyakKonstanta-1];

        hasil[0] = konstanta[0];

        // menghitung sisa dan hasilnya
        for (int i = 1; i < banyakKonstanta; i++){
            sisa = (sisa * x) + konstanta[i]; // rumus mencari sisa
            if(i < banyakKonstanta - 1){
                hasil[i] = sisa; // memasukkan konstanta hasil
            }
        }

        // output
        System.out.println("Hasil: " + bentukFx(hasil,hasil.length));
        System.out.println("Sisa: " + sisa);
    }
}
