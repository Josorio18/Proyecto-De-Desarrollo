package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaGestionPedidos extends JFrame {
    private final Sesion sesion;

    public VentanaGestionPedidos(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Gestión de Pedidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Gestión de Pedidos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID Pedido", "Cliente", "Estado"};
        Object[][] datos = {
                {"1001", "Juan Pérez", "En preparación"},
                {"1002", "Ana Torres", "Listo"},
                {"1003", "Carlos Sánchez", "Entregado"}
        };

        JTable tablaPedidos = new JTable(datos, columnas);
        panel.add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

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

        JButton btnGestionEmpleados = new JButton("Ir a Gestión de Empleados");
        btnGestionEmpleados.addActionListener(e -> {
            dispose();
            new VentanaGestionEmpleados(sesion);
        });

        JButton btnRegistroClientes = new JButton("Ir a Registro de Clientes");
        btnRegistroClientes.addActionListener(e -> {
            dispose();
            new VentanaRegistroClientes(sesion);
        });

        panelBotones.add(btnInventario);
        panelBotones.add(btnGestionEmpleados);
        panelBotones.add(btnRegistroClientes);
        panelBotones.add(btnRegresarMenu);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
