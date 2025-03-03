package Vistas;
import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaInventarioIngredientes extends JFrame {
    public VentanaInventarioIngredientes(Sesion sesion) {
        setTitle("Inventario de Ingredientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Inventario de Ingredientes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        // Tabla de ingredientes (ejemplo)
        String[] columnas = {"ID", "Nombre", "Cantidad", "Unidad"};
        Object[][] datos = {
                {"001", "Harina", "10", "kg"},
                {"002", "Carne", "5", "kg"},
                {"003", "Tomates", "15", "kg"},
                {"004", "Leche", "8", "L"},
                {"005", "Huevos", "30", "uds"}
        };

        JTable tablaIngredientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaIngredientes);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnRegresarConfiguracion = new JButton("Regresar a Configuración");
        btnRegresarConfiguracion.addActionListener(e -> {
            dispose();
            new VentanaConfiguracionSistema(sesion);
        });

        JButton btnRegresarMenu = new JButton("Regresar al Menú");
        btnRegresarMenu.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        panelBotones.add(btnRegresarConfiguracion);
        panelBotones.add(btnRegresarMenu);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}

