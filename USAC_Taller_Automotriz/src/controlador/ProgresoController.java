package controlador;

import modelo.*;

/**
 *
 * @author Anthony
 */
public class ProgresoController {

    private OrdenTrabajo[] ordenes;
    private int cantidadOrdenes;

    public ProgresoController() {
        this.ordenes = new OrdenTrabajo[200];
        this.cantidadOrdenes = 0;
    }

    // Agregar nueva orden de trabajo
    public void agregarOrdenTrabajo(OrdenTrabajo orden) {
        if (cantidadOrdenes < ordenes.length) {
            ordenes[cantidadOrdenes++] = orden;
        }
    }

    // Obtener todas las órdenes
    public OrdenTrabajo[] getOrdenes() {
        return ordenes;
    }

    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }

    // Buscar ordenes por estado
    public OrdenTrabajo[] buscarOrdenesPorEstado(String estadoBuscado) {
        OrdenTrabajo[] resultado = new OrdenTrabajo[cantidadOrdenes];
        int contador = 0;

        for (int i = 0; i < cantidadOrdenes; i++) {
            if (ordenes[i].getEstado().equalsIgnoreCase(estadoBuscado)) {
                resultado[contador++] = ordenes[i];
            }
        }
        return resultado;
    }

    // Cambiar estado de una orden
    public void cambiarEstadoOrden(OrdenTrabajo orden, String nuevoEstado) {
        orden.setEstado(nuevoEstado);
    }
}
