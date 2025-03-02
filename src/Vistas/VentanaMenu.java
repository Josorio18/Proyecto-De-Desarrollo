package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {
    public VentanaMenu(Sesion sesion) {
        setTitle("Menú del Restaurante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar layout principal centrado
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre elementos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Panel para los botones del menú
        JPanel panelMenu = new JPanel(new GridLayout(0, 1, 10, 10)); // Botones en columna

        String[] opciones = { "Gestión de Mesas" };
        Class<?>[] ventanas = { VentanaMesas.class };

        for (int i = 0; i < opciones.length; i++) {
            JButton boton = new JButton(opciones[i]);
            int index = i;
            boton.addActionListener(e -> {
                dispose();
                try {
                    ventanas[index].getDeclaredConstructor(Sesion.class).newInstance(sesion);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panelMenu.add(boton);
        }

        // Agregar el menú centrado
        add(panelMenu, gbc);

        // Botón "Salir" centrado justo debajo del menú
        gbc.gridy = 1;
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            sesion.cerrarSesion();
            dispose();
            new VentanaInicio(sesion);
        });

        add(btnSalir, gbc);

        setVisible(true);
    }
}
