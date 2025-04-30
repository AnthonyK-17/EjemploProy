package modelo;

import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public class Servicio implements Serializable {

    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int[] repuestos; // IDs de los repuestos
    private double precioManoObra;
    private double precioTotal;

    public Servicio(int id, String nombre, String marca, String modelo, int[] repuestos, double precioManoObra, double precioTotal) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.repuestos = repuestos;
        this.precioManoObra = precioManoObra;
        this.precioTotal = precioTotal;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int[] getRepuestos() {
        return repuestos;
    }

    public double getPrecioManoObra() {
        return precioManoObra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}
