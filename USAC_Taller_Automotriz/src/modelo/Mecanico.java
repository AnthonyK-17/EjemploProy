package modelo;

/**
 *
 * @author Anthony
 */
public class Mecanico extends Empleado {

    public Mecanico(String nombre, String usuario, String password) {
        super(nombre, usuario, password);
    }

    @Override
    public String toString() {
        return "Mecanico: " + getNombre();
    }
}