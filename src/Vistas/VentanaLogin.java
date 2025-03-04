package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;


public class VentanaLogin extends JFrame {
    private final Sesion sesion;


    public VentanaLogin(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Inicio de Sesión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Etiqueta y campo de texto para el usuario
        panel.add(new JLabel("Usuario:"));
        panel.add(new JTextField());

        // Etiqueta y campo de contraseña
        panel.add(new JLabel("Contraseña:"));
        panel.add(new JPasswordField());

        // Botón para ingresar al sistema
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(e -> {
            sesion.iniciarSesion();
            dispose();
            new VentanaMenu(sesion);
        });
        panel.add(btnIngresar);

        add(panel);
        setVisible(true);
    }
}