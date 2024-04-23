package AnalisisOrganizacion;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalisisRegistro {
    public static List<Venta> ordenarVentas(List<Venta> ventas) {
        return ventas.stream()
                .sorted(Comparator.comparing(Venta::getCantidad))
                .collect(Collectors.toList());
    }

    public static List<Venta> filtrarVentas(List<Venta> ventas) {
        return ventas.stream()
                .filter(venta -> venta.getCantidad() > 100)
                .collect(Collectors.toList());
    }
}