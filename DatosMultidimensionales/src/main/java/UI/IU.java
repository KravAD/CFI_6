package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU extends JFrame{
    public IU(){
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

        panel.add(botonDatosDinamicos);
        add(panel);

        pack();
    }
}