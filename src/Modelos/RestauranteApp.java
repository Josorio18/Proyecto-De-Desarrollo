package Modelos;

import Vistas.VentanaInicio;
import Servicios.Sesion;
import javax.swing.*;

public class RestauranteApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sesion sesion = new Sesion();
            new VentanaInicio(sesion);
        });
    }
}
