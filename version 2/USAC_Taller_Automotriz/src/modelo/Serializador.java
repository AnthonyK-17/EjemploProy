package modelo;

import java.io.*;

public class Serializador {

    // Guardar un objeto en un archivo binario
    public static void guardarObjeto(Object objeto, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
             new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.err.println("Error al guardar objeto: " + e.getMessage());
        }
    }

    // Cargar un objeto desde un archivo binario
    public static Object cargarObjeto(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
             new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar objeto: " + e.getMessage());
            return null;
        }
    }
}
