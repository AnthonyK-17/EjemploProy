package modelo;

import java.io.*;

public class Serializador {

    // Guardar un objeto en un archivo binario
    public static void guardarObjeto(String rutaArchivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Cargar un objeto desde un archivo binario
    public static Object cargarObjeto(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return null;
        }
    }
}
