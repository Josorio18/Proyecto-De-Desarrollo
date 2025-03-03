package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaConfiguracionSistema extends JFrame {
    public VentanaConfiguracionSistema(Sesion sesion) {
        setTitle("Configuración del Sistema");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelOpciones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnHistorialVentas = new JButton("Historial de ventas");
        JButton btnInventarioIngredientes = new JButton("Inventario de ingredientes");
        JButton btnRestablecer = new JButton("Restablecer Configuración");

        btnInventarioIngredientes.addActionListener(e -> {
            dispose();
            new VentanaInventarioIngredientes(sesion);
        });

        btnHistorialVentas.addActionListener(e -> {
            dispose();
            new VentanaHistorialVentas(sesion);
        });

        panelOpciones.add(btnHistorialVentas);
        panelOpciones.add(btnInventarioIngredientes);
        panelOpciones.add(btnRestablecer);

        // Panel de botones de navegación
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnRegresarMesas = new JButton("Regresar a Gestión de Mesas");
        btnRegresarMesas.addActionListener(e -> {
            dispose();
            new VentanaMesas(sesion);
        });

        JButton btnRegresarMenu = new JButton("Regresar al Menú");
        btnRegresarMenu.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        panelBotones.add(btnRegresarMesas);
        panelBotones.add(btnRegresarMenu);

        // Agregar paneles a la ventana
        add(panelOpciones, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}


