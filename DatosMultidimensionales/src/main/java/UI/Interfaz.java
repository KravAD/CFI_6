package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Interfaz extends JFrame{
    public Interfaz(){
        setTitle("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton botonDatosDinamicos = new JButton("Datos Dinámicos");
        botonDatosDinamicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaDatosDinamicos().setVisible(true);
            }
        });

        JButton botonIndexarArchivos = new JButton("Indexar Archivos");
        botonIndexarArchivos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexarArchivo indexador = new IndexarArchivo();
                indexador.indexarArchivos(new File("ruta/del/directorio"));
                String listadoArchivos = indexador.obtenerListadoArchivos();

                JTextArea areaTexto = new JTextArea(listadoArchivos);
                JScrollPane scrollPane = new JScrollPane(areaTexto);
                JOptionPane.showMessageDialog(null, scrollPane, "Listado de Archivos", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        panel.add(botonDatosDinamicos);
        panel.add(botonIndexarArchivos);
        add(panel);

        pack();
    }
}