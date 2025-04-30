package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Bitacora implements Serializable {

    private Date marcaTemporal;
    private String usuario;
    private String accion;
    private String resultado;
    private String detalles;

    public Bitacora(Date marcaTemporal, String usuario, String accion, String resultado, String detalles) {
        this.marcaTemporal = marcaTemporal;
        this.usuario = usuario;
        this.accion = accion;
        this.resultado = resultado;
        this.detalles = detalles;
    }

    // Getters
    public Date getMarcaTemporal() {
        return marcaTemporal;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getAccion() {
        return accion;
    }

    public String getResultado() {
        return resultado;
    }

    public String getDetalles() {
        return detalles;
    }
}
