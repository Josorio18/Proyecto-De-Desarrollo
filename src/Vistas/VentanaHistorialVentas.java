package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaHistorialVentas extends JFrame {
    public VentanaHistorialVentas(Sesion sesion) {
        setTitle("Historial de Ventas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área de texto para mostrar las ventas
        JTextArea areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        areaHistorial.setText("Aquí se mostrará el historial de ventas...\n");

        // Agregar barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(areaHistorial);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnRegresar = new JButton("Regresar a Configuración");
        btnRegresar.addActionListener(e -> {
            dispose();
            new VentanaConfiguracionSistema(sesion);
        });

        panelBotones.add(btnRegresar);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}

