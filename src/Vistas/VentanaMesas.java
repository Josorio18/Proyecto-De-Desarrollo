package Vistas;

import Servicios.Sesion;
import javax.swing.*;
import java.awt.*;

public class VentanaMesas extends JFrame {
    private final Sesion sesion;
    private static final int TOTAL_MESAS = 15;

    public VentanaMesas(Sesion sesion) {
        this.sesion = sesion;
        setTitle("Gestión de Mesas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel que contiene los botones de las mesas
        JPanel panelMesas = new JPanel(new GridLayout(3, 5, 10, 10));
        for (int i = 1; i <= TOTAL_MESAS; i++) {
            JButton btnMesa = new JButton("Mesa " + i);
            int mesaSeleccionada = i;
            btnMesa.addActionListener(e -> abrirPedidos(mesaSeleccionada));
            panelMesas.add(btnMesa);
        }

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> {
            dispose();
            new VentanaMenu(sesion);
        });

        setLayout(new BorderLayout());
        add(panelMesas, BorderLayout.CENTER);
        add(btnRegresar, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Método para abrir la gestión de pedidos de una mesa específica.
     * @param numeroMesa Número de la mesa seleccionada.
     */
    private void abrirPedidos(int numeroMesa) {
        dispose();
        // Lógica futura para abrir la ventana de pedidos de la mesa seleccionada
    }
}

