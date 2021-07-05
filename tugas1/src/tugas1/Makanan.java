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
 public abstract class Makanan {
    int kalori;

    public Makanan() {
        this.kalori = 200;
    }
    
    abstract void masak();
    
    void hitungKalori(){
        System.out.println("Kalori sebesar " + kalori);
    }
}


