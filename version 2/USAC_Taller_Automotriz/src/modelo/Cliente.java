package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String dpi;
    private String nombreCompleto;
    private String usuario;
    private String password;
    private String tipoCliente; // normal/oro
    private Automovil[] automoviles;
    private int cantidadAutomoviles; // cuántos autos lleva realmente

    public Cliente(String dpi, String nombreCompleto, String usuario, String password, String tipoCliente) {
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.password = password;
        this.tipoCliente = tipoCliente;
        this.automoviles = new Automovil[20]; // tamaño fijo puedo hacer cambios
        this.cantidadAutomoviles = 0;
    }

    public void agregarAutomovil(Automovil auto) {
        if (cantidadAutomoviles < automoviles.length) {
            automoviles[cantidadAutomoviles] = auto;
            cantidadAutomoviles++;
        }
    }

    public Automovil[] getAutomoviles() {
        return automoviles;
    }

    public int getCantidadAutomoviles() {
        return cantidadAutomoviles;
    }

    public String getDpi() {
        return dpi;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
