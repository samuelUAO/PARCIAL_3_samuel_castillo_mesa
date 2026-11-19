/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.principal;
import yugi.vista.VentanaCombate;
import yugi.modelo.Jugador;
import yugi.modelo.Monstruo;
import java.util.ArrayList;
/**
 *
 * @author SAMUEL
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Jugador> jugadores = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador 1", "001");
        Jugador jugador2 = new Jugador("Jugador 2", "002");

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        jugador1.agregarMonstruo(
            new Monstruo("Dragon Blanco", 3000, 2500)
        );

        jugador2.agregarMonstruo(
            new Monstruo("Dragon Rojo", 2800, 2000)
        );

        System.out.println("===== REPORTE 1: JUGADORES =====");

        for (Jugador jugador : jugadores) {
            System.out.println(jugador.mostrarDatos());
        }

        System.out.println("\n===== REPORTE 2: MONSTRUOS =====");

        for (Jugador jugador : jugadores) {
            for (Monstruo monstruo : jugador.getMonstruos()) {
                System.out.println(monstruo.mostrarInformacion());
            }
        }

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaCombate().setVisible(true);
        });
    }
}