package modelo;
import java.io.Serializable;
import java.util.Date;

public class OrdenTrabajo implements Serializable {
    private int numeroOrden;
    private Automovil automovil;
    private Cliente cliente;
    private Servicio servicio;
    private Date fecha;
    private Mecanico mecanico;
    private String estado; // "Cola de espera", "En servicio", "Listo"

    public OrdenTrabajo(int numeroOrden, Automovil automovil, Cliente cliente, Servicio servicio, Date fecha, Mecanico mecanico, String estado) {
        this.numeroOrden = numeroOrden;
        this.automovil = automovil;
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.mecanico = mecanico;
        this.estado = estado;
    }

    // Getters y Setters

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}