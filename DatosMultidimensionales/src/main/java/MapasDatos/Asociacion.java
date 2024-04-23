package MapasDatos;

import java.util.HashMap;
import java.util.Map;

public class Asociacion {
    public static void asociarNumerosLetras(Map<Integer, Character> map) {
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
    }

    public static void asociarNumerosTextuales(Map<Integer, String> map) {
        map.put(1, "Uno");
        map.put(2, "Dos");
        map.put(3, "Tres");
    }
}