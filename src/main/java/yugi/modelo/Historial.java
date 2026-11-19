/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/**
 *
 * @author SAMUEL
 */
public class Historial {

    private static final String ARCHIVO = "historial_combate.txt";

    public void guardarRegistro(String registro) {
        try {
            Path ruta = Paths.get(ARCHIVO);

            Files.writeString(
                ruta,
                registro + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    public String leerHistorial() {
        try {
            Path ruta = Paths.get(ARCHIVO);

            if (Files.exists(ruta)) {
                return Files.readString(ruta);
            }

            return "Todavía no hay combates registrados.";

        } catch (IOException e) {
            return "Error al leer el historial: " + e.getMessage();
        }
    }
}