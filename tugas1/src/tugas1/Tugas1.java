/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;
import java.util.Scanner;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Tugas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner input;
        input = new Scanner(System.in);
        
        
     Roti roti;
        roti = new Roti(180, "Denis Croisant ", 20000);
        roti.panggang();

     
     Puding puding;
        puding = new Puding ("putri", "Buah", 20000 );
        puding.makan();
        
        System.out.println("Masukkan suhu panggang tanpa celcius");

        System.out.println("Puding yang dicari = ");
        String namaPuding = input.next();
        puding.setNamaSnack(namaPuding);
     
        System.out.println("Puding " + namaPuding + " Harganya " + puding.harga);
        
        //abstract
        Snack snack = new Snack("Tepung");
        snack.masak();
        

}
    }
    
}
