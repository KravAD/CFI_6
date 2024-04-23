package org.example;
import UI.*;

import java.util.Map;
import java.util.TreeMap;
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

        //Algoritmo para ordenar ventas
        TreeMap<Integer, String> ventas = new TreeMap<>();
        ventas.put(100, "Venta1");
        ventas.put(200, "Venta2");
        ventas.put(150, "Venta3");
        ventas.put(50, "Venta4");

        for (Map.Entry<Integer, String> venta : ventas.entrySet()) {
            System.out.println("Cantidad: " + venta.getKey() + ", Venta: " + venta.getValue());
        }
    }
}