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
public class Puding extends Snack{
    String namaPemesan;

    public Puding(String namaPemesan, String namaSnack, int harga) {
        super(namaSnack, harga);
        this.namaPemesan = namaPemesan;
    }

    private String setNamaPemesan() {
        return namaPemesan;
    }
    
        public Puding(String namaSnack, int harga) {
        super( namaSnack, harga);
    }
        
    void makan(){
        System.out.println("Puding " + namaSnack + " Harganya " + harga);
    }

    public String getNamaSnack() {
        return namaSnack;
    }

    public void setNamaSnack(String namaSnack) {
        this.namaSnack = namaSnack;
    }
    
    //encapsulation
    boolean login(){
        if (this.namaPemesan.equals(namaPemesan)){
            return true;}
        else{
            return false;
        }
    }
}
