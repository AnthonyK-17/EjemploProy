package modelo;

import java.io.Serializable;

/**
 *
 * @author Anthony
 */

public class Automovil implements Serializable {

    private String placa;
    private String marca;
    private String modelo;
    private String rutaImagen;

    public Automovil(String placa, String marca, String modelo, String rutaImagen) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.rutaImagen = rutaImagen;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return placa + " - " + marca + " " + modelo;
    }
}
