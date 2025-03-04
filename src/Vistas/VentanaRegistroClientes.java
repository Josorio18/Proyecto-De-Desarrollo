package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroClientes extends JFrame {
    private final Sesion sesion;

    public VentanaRegistroClientes(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Registro de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Teléfono:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Correo Electrónico:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Dirección:"));
        panel.add(new JTextField());

        JButton btnRegistrar = new JButton("Registrar Cliente");
        panel.add(btnRegistrar);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnRegresarMenu = new JButton("Regresar al Menú");
        btnRegresarMenu.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        JButton btnInventario = new JButton("Ir a Inventario");
        btnInventario.addActionListener(e -> {
            dispose();
            new VentanaInventario(sesion);
        });

        JButton btnPedidos = new JButton("Ir a Pedidos");
        btnPedidos.addActionListener(e -> {
            dispose();
            new VentanaGestionPedidos(sesion);
        });

        JButton btnGestionEmpleados = new JButton("Ir a Gestión de Empleados");
        btnGestionEmpleados.addActionListener(e -> {
            dispose();
            new VentanaGestionEmpleados(sesion);
        });


        panelBotones.add(btnInventario);
        panelBotones.add(btnPedidos);
        panelBotones.add(btnGestionEmpleados);
        panelBotones.add(btnRegresarMenu);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }
}
