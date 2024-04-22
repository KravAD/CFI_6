package DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class DatosReales {
    private List<Double> datos;

    public DatosReales() {
        this.datos = new ArrayList<>();
    }
    public void agregarDato (double dato) {
        this.datos.add(dato);
    }
    public double obtenerDato (int posicion) {
        return this.datos.get(posicion);
    }
    public void eliminarDato (int posicion) {
        this.datos.remove(posicion);
    }

}
