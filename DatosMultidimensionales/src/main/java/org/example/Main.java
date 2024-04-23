// Main.java
package org.example;

import AnalisisOrganizacion.AnalisisRegistro;
import AnalisisOrganizacion.Venta;
import UI.Interfaz;

import java.util.ArrayList;
import java.util.List;
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

        List<Venta> ventas = new ArrayList<>();

        // Añadir ventas a la lista
        ventas.add(new Venta("Venta1", 120));
        ventas.add(new Venta("Venta2", 200));
        ventas.add(new Venta("Venta3", 150));
        ventas.add(new Venta("Venta4", 90));

        // Ordenar las ventas
        List<Venta> ventasOrdenadas = AnalisisRegistro.ordenarVentas(ventas);

        // Filtrar las ventas
        List<Venta> ventasFiltradas = AnalisisRegistro.filtrarVentas(ventas);

        System.out.println("\nVentas filtradas:");
        for (Venta venta : ventasFiltradas) {
            System.out.println("Nombres: " + nombres + " ID: " + venta.getId() + ", Cantidad: " + venta.getCantidad());
        }
    }
}