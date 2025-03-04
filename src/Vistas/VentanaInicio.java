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

        // Etiqueta de bienvenida
        JLabel labelTexto = new JLabel("Bienvenido a Restaurante Colombia", SwingConstants.CENTER);
        labelTexto.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(labelTexto, BorderLayout.CENTER);

        // Panel para los botones de navegación
        JPanel panelBotones = new JPanel(new FlowLayout());

        // Botón para continuar al inicio de sesión
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(e -> {
            dispose();
            new VentanaLogin(sesion);
        });

        // Botón para acceder a la gestión de empleados
        JButton btnGestionEmpleados = new JButton("Gestión de Empleados");
        btnGestionEmpleados.addActionListener(e -> {
            dispose();
            new VentanaGestionEmpleados(sesion);
        });

        // Botón para acceder a la gestión de pedidos
        JButton btnGestionPedidos = new JButton("Gestión de Pedidos");
        btnGestionPedidos.addActionListener(e -> {
            dispose();
            new VentanaGestionPedidos(sesion);
        });

        // Botón para acceder al inventario
        JButton btnInventario = new JButton("Inventario");
        btnInventario.addActionListener(e -> {
            dispose();
            new VentanaInventario(sesion);
        });

        // Botón para registrar clientes
        JButton btnRegistroClientes = new JButton("Registro de Clientes");
        btnRegistroClientes.addActionListener(e -> {
            dispose();
            new VentanaRegistroClientes(sesion);
        });

        // Agregar botones al panel
        panelBotones.add(btnContinuar);
        panelBotones.add(btnGestionEmpleados);
        panelBotones.add(btnGestionPedidos);
        panelBotones.add(btnInventario);
        panelBotones.add(btnRegistroClientes);

        panel.add(panelBotones, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }
}

