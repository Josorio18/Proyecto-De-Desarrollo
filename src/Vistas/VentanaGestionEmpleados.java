package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaGestionEmpleados extends JFrame {
    private final Sesion sesion;

    public VentanaGestionEmpleados(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Gestión de Empleados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Gestión de Empleados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Cargo"};
        Object[][] datos = {
                {"001", "Pedro López", "Cocinero"},
                {"002", "María Gómez", "Mesera"},
                {"003", "Carlos Ruiz", "Cajero"}
        };

        JTable tablaEmpleados = new JTable(datos, columnas);
        panel.add(new JScrollPane(tablaEmpleados), BorderLayout.CENTER);

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

        JButton btnPedidos = new JButton("Ir a Gestión de Pedidos");
        btnPedidos.addActionListener(e -> {
            dispose();
            new VentanaGestionPedidos(sesion);
        });

        JButton btnRegistroClientes = new JButton("Ir a Registro de Clientes");
        btnRegistroClientes.addActionListener(e -> {
            dispose();
            new VentanaRegistroClientes(sesion);
        });

        panelBotones.add(btnInventario);
        panelBotones.add(btnPedidos);
        panelBotones.add(btnRegistroClientes);
        panelBotones.add(btnRegresarMenu);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
