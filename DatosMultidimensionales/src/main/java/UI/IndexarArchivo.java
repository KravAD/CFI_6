package UI;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class IndexarArchivo {
    private Map<String, String> indiceArchivos = new TreeMap<>();

    public void indexarArchivos(File directorio) {
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarArchivos(archivo);
                } else {
                    indiceArchivos.put(archivo.getName(), archivo.getAbsolutePath());
                }
            }
        }
    }

    public String obtenerListadoArchivos() {
        StringBuilder listado = new StringBuilder();
        for (Map.Entry<String, String> entrada : indiceArchivos.entrySet()) {
            listado.append("Nombre del archivo: ").append(entrada.getKey()).append(", Ruta: ").append(entrada.getValue()).append("\n");
        }
        return listado.toString();
    }
}