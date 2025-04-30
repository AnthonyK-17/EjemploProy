package util;

import modelo.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class GeneradorArchivosIniciales {

    public static void main(String[] args) {
        try {
            // 1. Generar archivo de empleados (admin.dat)
            generarArchivoEmpleados();

            // 2. Generar archivo de clientes (clientes.dat)
            generarArchivoClientes();

            // 3. Generar archivo de repuestos (repuestos.dat)
            generarArchivoRepuestos();

            // 4. Generar archivo de servicios (servicios.dat)
            generarArchivoServicios();

            System.out.println("Archivos .dat generados exitosamente!");
        } catch (Exception e) {
            System.err.println("Error al generar archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void generarArchivoEmpleados() throws Exception {
        Empleado[] empleados = new Empleado[2];

        // Administrador principal - versión con 3 parámetros
        empleados[0] = new Administrador(
                "admin", // usuario
                "admin123", // password
                "Admin Principal" // nombre
        );

        // Mecánico de ejemplo - versión con 3 parámetros
        empleados[1] = new Mecanico(
                "mecanico", // usuario
                "mecanico123", // password
                "Mecánico Ejemplo" // nombre
        );

        guardarObjeto(empleados, "admin.dat");
    }

    private static void generarArchivoClientes() throws Exception {
        Cliente[] clientes = new Cliente[3];

        // Cliente normal
        clientes[0] = new Cliente(
                "1234567890002",
                "Cliente Normal",
                "cliente",
                "cliente123",
                "normal"
        );
        clientes[0].agregarAutomovil(new Automovil("ABC123", "Toyota", "Corolla 2020", ""));

        // Cliente oro
        clientes[1] = new Cliente(
                "2345678901234",
                "Cliente Oro",
                "clienteoro",
                "oro123",
                "oro"
        );
        clientes[1].agregarAutomovil(new Automovil("XYZ789", "Honda", "Civic 2021", ""));

        // Otro cliente
        clientes[2] = new Cliente(
                "3456789012345",
                "Juan Pérez",
                "juan",
                "juan123",
                "normal"
        );
        clientes[2].agregarAutomovil(new Automovil("DEF456", "Mazda", "3 2019", ""));

        guardarObjeto(clientes, "clientes.dat");
    }

    private static void generarArchivoRepuestos() throws Exception {
        Repuesto[] repuestos = new Repuesto[5];

        repuestos[0] = new Repuesto(1, "Filtro de aire", "Toyota", "Corolla 2020", 10, 250.50);
        repuestos[1] = new Repuesto(2, "Pastillas de freno", "Honda", "Civic 2021", 15, 350.75);
        repuestos[2] = new Repuesto(3, "Aceite sintético", "Genérico", "Todos", 50, 180.00);
        repuestos[3] = new Repuesto(4, "Batería", "Mazda", "3 2019", 8, 1200.00);
        repuestos[4] = new Repuesto(5, "Amortiguador", "Toyota", "Corolla 2020", 5, 800.25);

        guardarObjeto(repuestos, "repuestos.dat");
    }

    private static void generarArchivoServicios() throws Exception {
        Servicio[] servicios = new Servicio[4];
        int[] repuestosDiagnostico = {};
        int[] repuestosAceite = {3}; // Aceite sintético
        int[] repuestosFrenos = {2}; // Pastillas de freno
        int[] repuestosAlineacion = {};

        servicios[0] = new Servicio(1, "Diagnóstico", "General", "Todos", repuestosDiagnostico, 100.00, 100.00);
        servicios[1] = new Servicio(2, "Cambio de aceite", "General", "Todos", repuestosAceite, 150.00, 330.00);
        servicios[2] = new Servicio(3, "Cambio de frenos", "Honda", "Civic 2021", repuestosFrenos, 200.00, 550.75);
        servicios[3] = new Servicio(4, "Alineación y balanceo", "General", "Todos", repuestosAlineacion, 300.00, 300.00);

        guardarObjeto(servicios, "servicios.dat");
    }

    private static void guardarObjeto(Object objeto, String nombreArchivo) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
        }
    }
}
