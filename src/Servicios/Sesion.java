package Servicios;

public class Sesion {
    private boolean sesionIniciada;

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void iniciarSesion() {
        sesionIniciada = true;
    }

    public void cerrarSesion() {
        sesionIniciada = false;
    }
}