/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefrArrayList;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class MainRefArrayList1Refractorizad {
    
    public static void main(String[] args) {
        
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Nombre1");
        nombres.add("Nombre2");
        
        printList(nombres);
        
        nombres.add("Nombre3");
        nombres.remove("Nombre1");
        
        printList(nombres);
        
        nombres.add("Nombre1");
        nombres.remove("Nombre3");
        nombres.add("Nombre4");
        
        printList(nombres);
    }

    private static void printList(ArrayList<String> nombres) {
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        System.out.println("-----");
    }
}
