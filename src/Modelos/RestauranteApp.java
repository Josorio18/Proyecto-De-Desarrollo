package Modelos;

import Vistas.VentanaInicio;
import Servicios.Sesion;
import javax.swing.*;

/**
 * Clase principal que inicia la aplicación del restaurante.
 * Se encarga de crear una sesión y abrir la ventana de inicio.
 */
public class RestauranteApp {
    public static void main(String[] args) {
        // Ejecuta la aplicación en el hilo de eventos de Swing para garantizar la correcta gestión de la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            // Crea una nueva sesión para gestionar la autenticación del usuario
            Sesion sesion = new Sesion();

            // Inicia la ventana de inicio con la sesión creada
            new VentanaInicio(sesion);
        });
    }
}

