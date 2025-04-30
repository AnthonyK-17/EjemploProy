package modelo;

/**
 *
 * @author Anthony
 */
public class Ordenamientos {

    // Burbuja para Clientes (por DPI ascendente)
    public static void ordenarClientesPorDPI(Cliente[] clientes, int cantidad) {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - i - 1; j++) {
                if (clientes[j].getDpi().compareTo(clientes[j + 1].getDpi()) > 0) {
                    Cliente temp = clientes[j];
                    clientes[j] = clientes[j + 1];
                    clientes[j + 1] = temp;
                }
            }
        }
    }

    // ShellSort para Automóviles (por placa ascendente o descendente)
    public static void shellSortAutomoviles(Automovil[] autos, int cantidad, boolean ascendente) {
        int salto = cantidad / 2;
        while (salto > 0) {
            for (int i = salto; i < cantidad; i++) {
                Automovil temp = autos[i];
                int j = i;
                if (ascendente) {
                    while (j >= salto && autos[j - salto].getPlaca().compareTo(temp.getPlaca()) > 0) {
                        autos[j] = autos[j - salto];
                        j -= salto;
                    }
                } else {
                    while (j >= salto && autos[j - salto].getPlaca().compareTo(temp.getPlaca()) < 0) {
                        autos[j] = autos[j - salto];
                        j -= salto;
                    }
                }
                autos[j] = temp;
            }
            salto /= 2;
        }
    }
}
