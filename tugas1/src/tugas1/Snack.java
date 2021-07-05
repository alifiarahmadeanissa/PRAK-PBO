/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;

/**
 *
 * @author ASUS
 */
public class Snack extends Makanan{
    String namaSnack;
    int harga;
    String bahanDasar;

    public Snack(String bahanDasar) {
        this.bahanDasar = bahanDasar;
    }

    public Snack(String namaSnack, int harga) {
        this.namaSnack = namaSnack;
        this.harga = harga;
    }

    
    public void beli(){
        System.out.println("Alifia Membeli " + namaSnack);
        System.out.println("Harga Snack "+ harga);
    }

    //Override
    @Override
    void masak() {
        System.out.println("Bahan dasarnya adalah  " + bahanDasar);
    }

}


