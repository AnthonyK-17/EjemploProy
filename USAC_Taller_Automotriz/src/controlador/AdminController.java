package controlador;

import modelo.*;

/**
 *
 * @author Anthony
 */
public class AdminController {

    private Repuesto[] repuestos;
    private Servicio[] servicios;
    private Cliente[] clientes;
    private Empleado[] empleados;

    private int cantidadRepuestos;
    private int cantidadServicios;
    private int cantidadClientes;
    private int cantidadEmpleados;

    public AdminController() {
        this.repuestos = new Repuesto[100];
        this.servicios = new Servicio[100];
        this.clientes = new Cliente[100];
        this.empleados = new Empleado[20];

        this.cantidadRepuestos = 0;
        this.cantidadServicios = 0;
        this.cantidadClientes = 0;
        this.cantidadEmpleados = 0;
    }

    // --- REPUESTOS ---
    public void agregarRepuesto(Repuesto repuesto) {
        if (cantidadRepuestos < repuestos.length) {
            repuestos[cantidadRepuestos++] = repuesto;
        }
    }

    public Repuesto[] getRepuestos() {
        return repuestos;
    }

    public int getCantidadRepuestos() {
        return cantidadRepuestos;
    }

    // --- SERVICIOS ---
    public void agregarServicio(Servicio servicio) {
        if (cantidadServicios < servicios.length) {
            servicios[cantidadServicios++] = servicio;
        }
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    // --- CLIENTES ---
    public void agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes++] = cliente;
            Ordenamientos.ordenarClientesPorDPI(clientes, cantidadClientes); // Burbuja
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    // --- EMPLEADOS ---
    public void agregarEmpleado(Empleado empleado) {
        if (cantidadEmpleados < empleados.length) {
            empleados[cantidadEmpleados++] = empleado;
        }
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void cargarDatos() {
        // Definir ruta de la carpeta data
        String carpetaData = "data/";

        // Cargar empleados
        empleados = (Empleado[]) Serializador.cargarObjeto(carpetaData + "empleados.dat");
        if (empleados == null) {
            empleados = new Empleado[0];
            System.out.println("Advertencia: No se encontró el archivo de empleados");
        }
        cantidadEmpleados = empleados.length;

        // Cargar clientes
        clientes = (Cliente[]) Serializador.cargarObjeto(carpetaData + "clientes.dat");
        if (clientes == null) {
            clientes = new Cliente[0];
            System.out.println("Advertencia: No se encontró el archivo de clientes");
        }
        cantidadClientes = clientes.length;
    }
}
