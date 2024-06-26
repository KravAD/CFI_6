package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Interfaz extends JFrame {
    private IndexarArchivo indexador = new IndexarArchivo();

    public Interfaz() {
        setTitle("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(getClass().getResource("/uax.jpeg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        JButton botonDatosDinamicos = new JButton("Datos Dinámicos");
        botonDatosDinamicos.setFont(new Font("Arial", Font.BOLD, 14));
        botonDatosDinamicos.setBackground(Color.BLUE);
        botonDatosDinamicos.setForeground(Color.WHITE);
        botonDatosDinamicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaDatosDinamicos().setVisible(true);
            }
        });

        JButton botonIndexarArchivos = new JButton("Indexar Archivos");
        botonIndexarArchivos.setFont(new Font("Arial", Font.BOLD, 14));
        botonIndexarArchivos.setBackground(Color.BLUE);
        botonIndexarArchivos.setForeground(Color.WHITE);
        botonIndexarArchivos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rutaDirectorio = JOptionPane.showInputDialog("Introduce la ruta del directorio que deseas indexar:");
                File directorio = new File(rutaDirectorio);
                if (directorio.exists() && directorio.isDirectory()) {
                    indexador.indexarArchivos(directorio);
                    String listadoArchivos = indexador.obtenerListadoArchivos();
                    if (!listadoArchivos.isEmpty()) {
                        JTextArea areaTexto = new JTextArea(listadoArchivos);
                        JScrollPane scrollPane = new JScrollPane(areaTexto);
                        JOptionPane.showMessageDialog(null, scrollPane, "Listado de Archivos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El directorio no contiene archivos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El directorio proporcionado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botonRutasGuardadas = new JButton("Rutas Guardadas");
        botonRutasGuardadas.setFont(new Font("Arial", Font.BOLD, 14));
        botonRutasGuardadas.setBackground(Color.BLUE);
        botonRutasGuardadas.setForeground(Color.WHITE);
        botonRutasGuardadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JList<String> listaRutas = new JList<>(indexador.getRutasIndexadas().toArray(new String[0]));
                listaRutas.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        JList list = (JList)evt.getSource();
                        if (evt.getClickCount() == 2) {
                            int index = list.locationToIndex(evt.getPoint());
                            File directorio = new File(list.getModel().getElementAt(index).toString());
                            indexador.indexarArchivos(directorio);
                            String listadoArchivos = indexador.obtenerListadoArchivos();
                            JTextArea areaTexto = new JTextArea(listadoArchivos);
                            JScrollPane scrollPane = new JScrollPane(areaTexto);
                            JOptionPane.showMessageDialog(null, scrollPane, "Listado de Archivos", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
                JOptionPane.showMessageDialog(null, new JScrollPane(listaRutas), "Rutas Guardadas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(botonDatosDinamicos);
        panel.add(botonIndexarArchivos);
        panel.add(botonRutasGuardadas);
        add(panel);

        pack();
    }
}