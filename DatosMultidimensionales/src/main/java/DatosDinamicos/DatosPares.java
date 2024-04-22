package DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class DatosPares {
    private List<Pareja> pares;

    public DatosPares() {
        this.pares = new ArrayList<>();
    }
    public void agregarPar(Pareja par) {
        this.pares.add(par);
    }

    public Pareja obtenerPar(int indice) {
        return this.pares.get(indice);
    }

    public void eliminarPar(int indice) {
        this.pares.remove(indice);
    }
}
