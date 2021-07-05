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
//inheritance
public class Roti extends Snack{
    int suhuPanggang;
    int laba;
    
    public Roti(int suhuPanggang, int laba, String namaSnack, int harga) {
        super(namaSnack, harga);
        this.suhuPanggang = suhuPanggang;
        this.laba = laba;
    }

    public Roti(int suhuPanggang, String namaSnack, int harga) {
        super(namaSnack, harga);
        this.suhuPanggang = suhuPanggang;
    }
    
    //Overloading
    int Roti(float laba){
        return harga*(10/100);
    }


    public void panggang(){
        System.out.println("Ibu Memanggang " + namaSnack + " dengan suhu " + suhuPanggang + " derajat celcius");
        System.out.println("Roti "+ namaSnack + " seharga " + harga);
    }

    void laba() {
        System.out.println("Laba Sebesar " + laba);
    }
    
    
}

