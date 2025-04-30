package controlador;

import modelo.*;

public class ClienteController {

    private Cliente clienteActual;

    public ClienteController(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    // Agregar automovil
    public void agregarAutomovil(Automovil automovil) {
        clienteActual.agregarAutomovil(automovil);
        Ordenamientos.shellSortAutomoviles(clienteActual.getAutomoviles(), clienteActual.getCantidadAutomoviles(), true); // Ascendente
    }

    // Obtener autos
    public Automovil[] obtenerAutomoviles() {
        return clienteActual.getAutomoviles();
    }

    public int obtenerCantidadAutomoviles() {
        return clienteActual.getCantidadAutomoviles();
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }
}
