package controlador;

import modelo.Bitacora;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class BitacoraManager {

    private Bitacora[] bitacoras;
    private int cantidad;

    public BitacoraManager() {
        this.bitacoras = new Bitacora[500]; // Tamaño estimado
        this.cantidad = 0;
    }

    // Agregar una entrada nueva a la bitácora
    public void registrarEvento(String usuario, String accion, String resultado, String detalles) {
        if (cantidad < bitacoras.length) {
            Bitacora nueva = new Bitacora(new Date(), usuario, accion, resultado, detalles);
            bitacoras[cantidad++] = nueva;
        }
    }

    // Obtener todas las bitácoras registradas
    public Bitacora[] getBitacoras() {
        return bitacoras;
    }

    public int getCantidad() {
        return cantidad;
    }
}
