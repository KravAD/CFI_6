package UI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDatosDinamicos extends JFrame {
    private DefaultTableModel modeloTabla;
    private JTable tablaDatos;

    public VentanaDatosDinamicos() {
        setTitle("Datos Dinámicos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JTextField campoTexto = new JTextField(20);
        JButton botonAnadir = new JButton("Añadir");
        botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText();
                if (!texto.isEmpty()) {
                    modeloTabla.addRow(new Object[]{texto});
                    campoTexto.setText("");
                }
            }
        });

        JButton botonModificar = new JButton("Modificar");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaDatos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String nuevoDato = JOptionPane.showInputDialog("Introduce el nuevo dato:");
                    modeloTabla.setValueAt(nuevoDato, filaSeleccionada, 0);
                }
            }
        });

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaDatos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    modeloTabla.removeRow(filaSeleccionada);
                }
            }
        });

        panel.add(campoTexto);
        panel.add(botonAnadir);
        panel.add(botonModificar);
        panel.add(botonEliminar);

        modeloTabla = new DefaultTableModel(new Object[]{"Datos"}, 0);
        tablaDatos = new JTable(modeloTabla);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(tablaDatos), BorderLayout.CENTER);

        pack();
    }
}