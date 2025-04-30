package modelo;

import java.io.Serializable;

public class GeneradorID implements Serializable {
    private static int idRepuesto = 1;
    private static int idServicio = 1;
    private static int idOrdenTrabajo = 1;
    private static int idCliente = 1;
    private static int idMecanico = 1;

    // Métodos para generar IDs
    public static synchronized int generarIDRepuesto() {
        return idRepuesto++;
    }

    public static synchronized int generarIDServicio() {
        return idServicio++;
    }

    public static synchronized int generarIDOrdenTrabajo() {
        return idOrdenTrabajo++;
    }

    public static synchronized int generarIDCliente() {
        return idCliente++;
    }

    public static synchronized int generarIDMecanico() {
        return idMecanico++;
    }

    // Métodos para establecer valores iniciales (útil al cargar datos)
    public static synchronized void setIdRepuesto(int id) {
        if(id > idRepuesto) {
            idRepuesto = id;
        }
    }

    public static synchronized void setIdServicio(int id) {
        if(id > idServicio) {
            idServicio = id;
        }
    }

    public static synchronized void setIdOrdenTrabajo(int id) {
        if(id > idOrdenTrabajo) {
            idOrdenTrabajo = id;
        }
    }

    public static synchronized void setIdCliente(int id) {
        if(id > idCliente) {
            idCliente = id;
        }
    }

    public static synchronized void setIdMecanico(int id) {
        if(id > idMecanico) {
            idMecanico = id;
        }
    }

    // Método para obtener el próximo ID sin incrementar (útil para previsualización)
    public static synchronized int obtenerProximoIDRepuesto() {
        return idRepuesto;
    }

    public static synchronized int obtenerProximoIDServicio() {
        return idServicio;
    }

    public static synchronized int obtenerProximoIDOrdenTrabajo() {
        return idOrdenTrabajo;
    }
}