/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo1;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class ProvaLlistaPersona {
    public static void main(String[] args) {
        ArrayList<Persona> employees = new ArrayList<Persona>();
        employees.add(new Persona("Miquel","Amoros","Alberich","Profesor",37));
        employees.add(new Persona("Pildoras","Informaticas","","Profesor",20));
        employees.add(new Persona("Anonymus","Anonymus","","Investigador",99));      

        llistaPersones(employees);
        
    }

    private static void llistaPersones(ArrayList<Persona> employees) {
//        for (Persona employee : employees) {
//            // System.out.println(employee.salutacioFormal());
//            employee.salutacioFormal();
//        }
        System.out.println("----");
        for (Persona employee : employees) {
            System.out.println(employee);
        }
        System.out.println("----");
    }
}
