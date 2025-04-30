package controlador;

import modelo.*;
import java.util.Arrays;
import java.io.File;

public class ClienteController {

    private Cliente[] clientes;
    private Cliente clienteActual;

    private Repuesto[] repuestos;
    private Servicio[] servicios;
    private Empleado[] empleados;

    private int cantidadRepuestos;
    private int cantidadServicios;
    private int cantidadClientes;
    private int cantidadEmpleados;

    public ClienteController() {
        cargarDatos(); // Carga datos desde clientes.dat
    }

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

    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes++] = cliente;
            Ordenamientos.ordenarClientesPorDPI(clientes, cantidadClientes);
            guardarClientes(); // Guardar después de agregar
        }
    }

    public void cargarDatos() {
        // Definir ruta de la carpeta data
        String carpetaData = "data/";
        // Cargar clientes
        clientes = (Cliente[]) Serializador.cargarObjeto(carpetaData + "clientes.dat");
        if (clientes == null) {
            clientes = new Cliente[100];
            cantidadClientes = 0;
            System.out.println("Advertencia: No se encontró el archivo de clientes");
        } else {
            cantidadClientes = clientes.length;
        }
        // Cargar empleados
        empleados = (Empleado[]) Serializador.cargarObjeto(carpetaData + "admin.dat");
        if (empleados == null) {
            empleados = new Empleado[0];
            System.out.println("Advertencia: No se encontró el archivo de admin");
        }
        cantidadEmpleados = empleados.length;

    }

    public void guardarClientes() {
        String carpetaData = "data/";
        // Crear la carpeta si no existe
        new File(carpetaData).mkdirs();

        Cliente[] clientesParaGuardar = Arrays.copyOf(clientes, cantidadClientes);
        Serializador.guardarObjeto(clientesParaGuardar, carpetaData + "clientes.dat");
    }

    public boolean existeCliente(String dpi, String usuario) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getDpi().equals(dpi)
                    || clientes[i].getUsuario().equalsIgnoreCase(usuario)) {
                return true;
            }
        }
        return false;
    }

}
