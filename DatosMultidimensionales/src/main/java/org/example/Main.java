package org.example;
import UI.*;

import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
         Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);

        // Algoritmo para ordenar nombres
        TreeSet<String> nombres = new TreeSet<>();
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Felipe");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}