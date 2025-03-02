package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaInicio extends JFrame {
    private final Sesion sesion;

    public VentanaInicio(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Bienvenido al Restaurante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout());


        JLabel labelTexto = new JLabel("Bienvenido a Restaurante Colombia", SwingConstants.CENTER);
        labelTexto.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(labelTexto, BorderLayout.CENTER);


        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(e -> {
            dispose();
            new VentanaLogin(sesion);
        });

        panel.add(btnContinuar, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }
}
