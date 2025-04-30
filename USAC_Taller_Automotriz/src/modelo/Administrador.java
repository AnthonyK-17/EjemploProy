package modelo;

/**
 *
 * @author Anthony
 */
public class Administrador extends Empleado {

    public Administrador(String nombre, String usuario, String contraseña) {
        super(nombre, usuario, contraseña);
    }

    @Override
    public String toString() {
        return "Administrador: " + getNombre();
    }
}
