package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaPedidos extends JFrame {
    private final Sesion sesion;

    public VentanaPedidos(Sesion sesion) {
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
                {"001", "Juan Pérez", "En preparación"},
                {"002", "Ana Gómez", "Listo"},
                {"003", "Carlos Ruiz", "Entregado"}
        };

        JTable tablaPedidos = new JTable(datos, columnas);
        panel.add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnRegresarInventario = new JButton("Regresar a Inventario");
        btnRegresarInventario.addActionListener(e -> {
            dispose();
            new VentanaInventario(sesion);
        });

        JButton btnRegresarMenu = new JButton("Regresar al Menú");
        btnRegresarMenu.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        panelBotones.add(btnRegresarInventario);
        panelBotones.add(btnRegresarMenu);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
