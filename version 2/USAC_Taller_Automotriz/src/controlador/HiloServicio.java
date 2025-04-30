package controlador;

import modelo.OrdenTrabajo;

public class HiloServicio extends Thread {

    private OrdenTrabajo orden;
    private ProgresoController progresoController;
    private BitacoraManager bitacoraManager;

    public HiloServicio(OrdenTrabajo orden, ProgresoController progresoController, BitacoraManager bitacoraManager) {
        this.orden = orden;
        this.progresoController = progresoController;
        this.bitacoraManager = bitacoraManager;
    }

    @Override
    public void run() {
        try {
            // 1. Estado: Cola de Espera
            progresoController.cambiarEstadoOrden(orden, "Cola de espera");
            bitacoraManager.registrarEvento(
                    orden.getCliente().getUsuario(),
                    "Automóvil en cola de espera",
                    "Éxito",
                    "Placa: " + orden.getAutomovil().getPlaca()
            );
            sleep(14000); // 14 segundos

            // 2. Estado: En Servicio
            progresoController.cambiarEstadoOrden(orden, "En servicio");
            bitacoraManager.registrarEvento(
                    orden.getCliente().getUsuario(),
                    "Automóvil en servicio",
                    "Éxito",
                    "Placa: " + orden.getAutomovil().getPlaca()
            );
            sleep(9000); // 9 segundos

            // 3. Estado: Listo
            progresoController.cambiarEstadoOrden(orden, "Listo");
            bitacoraManager.registrarEvento(
                    orden.getCliente().getUsuario(),
                    "Automóvil listo para entrega",
                    "Éxito",
                    "Placa: " + orden.getAutomovil().getPlaca()
            );
            sleep(6000); // 6 segundos

        } catch (InterruptedException e) {
            System.out.println("Error en hilo de servicio: " + e.getMessage());
        }
    }
}
