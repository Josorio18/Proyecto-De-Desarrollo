package Servicios;

/**
 * Clase que gestiona la sesión del usuario en el sistema.
 * Permite iniciar y cerrar sesión, además de verificar su estado.
 */
public class Sesion {
    private boolean sesionIniciada;

    /**
     * Verifica si la sesión está iniciada.
     * @return true si la sesión está iniciada, false en caso contrario.
     */
    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    /**
     * Inicia la sesión del usuario.
     */
    public void iniciarSesion() {
        sesionIniciada = true;
    }

    /**
     * Cierra la sesión del usuario.
     */
    public void cerrarSesion() {
        sesionIniciada = false;
    }
}
