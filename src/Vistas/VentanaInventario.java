package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaInventario extends JFrame {
    private final Sesion sesion;

    public VentanaInventario(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Inventario del Restaurante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Título del inventario
        JLabel titulo = new JLabel("Inventario del Restaurante", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo, BorderLayout.NORTH);

        // Definición de columnas y datos de inventario
        String[] columnas = {"ID", "Producto", "Cantidad", "Unidad"};
        Object[][] datos = {
                {"001", "Harina", "10", "kg"},
                {"002", "Carne", "5", "kg"},
                {"003", "Tomates", "15", "kg"},
                {"004", "Leche", "8", "L"},
                {"005", "Huevos", "30", "uds"}
        };

        // Creación de la tabla de inventario
        JTable tablaInventario = new JTable(datos, columnas);
        panel.add(new JScrollPane(tablaInventario), BorderLayout.CENTER);

        // Panel de botones para navegación
        JPanel panelBotones = new JPanel(new FlowLayout());

        // Botón para regresar a la gestión de pedidos
        JButton btnRegresarPedidos = new JButton("Regresar a Pedidos");
        btnRegresarPedidos.addActionListener(e -> {
            dispose();
            new VentanaGestionPedidos(sesion);
        });

        // Botón para regresar al menú principal
        JButton btnRegresarMenu = new JButton("Regresar al Menú");
        btnRegresarMenu.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        panelBotones.add(btnRegresarPedidos);
        panelBotones.add(btnRegresarMenu);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
