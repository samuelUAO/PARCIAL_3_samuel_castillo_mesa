/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.controlador;

import yugi.modelo.Jugador;
import yugi.modelo.Monstruo;
import yugi.modelo.Combate;
/**
 *
 * @author SAMUEL
 */
public class ControladorCombate {

    private Jugador jugador1;
    private Jugador jugador2;
    private Combate combate;

    public ControladorCombate() {
        jugador1 = new Jugador("Jugador 1", "001");
        jugador2 = new Jugador("Jugador 2", "002");

        combate = new Combate(jugador1, jugador2);

        // Monstruos iniciales del jugador 1
        jugador1.agregarMonstruo(
            new Monstruo("Dragon Blanco", 3000, 2500)
        );

        jugador1.agregarMonstruo(
            new Monstruo("Mago Oscuro", 2500, 2100)
        );

        // Monstruos iniciales del jugador 2
        jugador2.agregarMonstruo(
            new Monstruo("Dragon Rojo", 2800, 2000)
        );

        jugador2.agregarMonstruo(
            new Monstruo("Guerrero", 1800, 1500)
        );
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public String atacar(int indiceAtacante, int indiceDefensor) {

        if (indiceAtacante < 0 ||
            indiceAtacante >= jugador1.getMonstruos().size()) {
            return "Selecciona un monstruo atacante válido.";
        }

        if (indiceDefensor < -1 ||
            indiceDefensor >= jugador2.getMonstruos().size()) {
            return "Selecciona un monstruo defensor válido.";
        }

        Monstruo atacante =
            jugador1.getMonstruos().get(indiceAtacante);

        Monstruo defensor = null;

        if (indiceDefensor != -1) {
            defensor = jugador2.getMonstruos().get(indiceDefensor);
        }

        return combate.ejecutarCombate(atacante, defensor);
    }

    public String obtenerEstado() {
        return jugador1.mostrarDatos()
                + "\n"
                + jugador2.mostrarDatos();
    }

    public String obtenerMonstruosJugador1() {
    String texto = "";

    for (int i = 0; i < jugador1.getMonstruos().size(); i++) {
        Monstruo m = jugador1.getMonstruos().get(i);

        texto += (i + 1) + ". " + m.getNombreMonstruo()
                + "\n   ATK: " + m.getAtaque()
                + " | DEF: " + m.getDefensa()
                + " | " + m.getPosicion()
                + "\n\n";
    }

    return texto;
}

    public String obtenerMonstruosJugador2() {
    String texto = "";

    for (int i = 0; i < jugador2.getMonstruos().size(); i++) {
        Monstruo m = jugador2.getMonstruos().get(i);

        texto += (i + 1) + ". " + m.getNombreMonstruo()
                + "\n   ATK: " + m.getAtaque()
                + " | DEF: " + m.getDefensa()
                + " | " + m.getPosicion()
                + "\n\n";
    }

    return texto;
}

    public boolean hayGanador() {
        return !jugador1.estaVivo() || !jugador2.estaVivo();
    }

    public String obtenerGanador() {
        if (!jugador1.estaVivo()) {
            return jugador2.getNombre() + " ha ganado.";
        }

        if (!jugador2.estaVivo()) {
            return jugador1.getNombre() + " ha ganado.";
        }

        return "El combate continúa.";
    }
}
