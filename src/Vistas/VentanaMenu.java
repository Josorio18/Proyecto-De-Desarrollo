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
        setLayout(new BorderLayout());

        // Panel de Platos
        JPanel panelPlatos = new JPanel(new GridLayout(0, 1, 10, 10));
        JLabel titulo = new JLabel("Platos Disponibles", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelPlatos.add(titulo);

        String[] platos = {
                "Bandeja Paisa - $35,000",
                "Ajiaco - $25,000",
                "Sancocho - $30,000",
                "Arepa Rellena - $15,000",
                "Empanadas (5 uds) - $10,000",
                "Jugo Natural - $8,000"
        };

        for (String plato : platos) {
            JLabel etiquetaPlato = new JLabel(plato, SwingConstants.CENTER);
            panelPlatos.add(etiquetaPlato);
        }

        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnMesas = new JButton("Gestión de Mesas");
        btnMesas.addActionListener(e -> {
            dispose();
            new VentanaMesas(sesion);
        });

        JButton btnConfiguracion = new JButton("Configuración del Sistema");
        btnConfiguracion.addActionListener(e -> {
            dispose();
            new VentanaConfiguracionSistema(sesion);
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            sesion.cerrarSesion();
            dispose();
            new VentanaInicio(sesion);
        });

        panelBotones.add(btnMesas);
        panelBotones.add(btnConfiguracion);
        panelBotones.add(btnSalir);

        add(panelPlatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}


