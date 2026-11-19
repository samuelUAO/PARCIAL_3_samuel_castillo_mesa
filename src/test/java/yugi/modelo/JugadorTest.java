/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author SAMUEL
 */
public class JugadorTest {

    @Test
    public void probarPuntosVidaIniciales() {
        Jugador jugador = new Jugador("Samuel", "001");

        assertEquals(8000, jugador.getPuntosVida());
    }

    @Test
    public void probarRecibirDanio() {
        Jugador jugador = new Jugador("Samuel", "001");

        jugador.recibirDanio(2000);

        assertEquals(6000, jugador.getPuntosVida());
    }

    @Test
    public void probarQueLosPuntosNoSeanNegativos() {
        Jugador jugador = new Jugador("Samuel", "001");

        jugador.recibirDanio(10000);

        assertEquals(0, jugador.getPuntosVida());
        assertFalse(jugador.estaVivo());
    }

    @Test
    public void probarDanioNegativo() {
        Jugador jugador = new Jugador("Samuel", "001");

        jugador.recibirDanio(-500);

        assertEquals(8000, jugador.getPuntosVida());
    }

    @Test
    public void probarJugadorVivo() {
        Jugador jugador = new Jugador("Samuel", "001");

        assertTrue(jugador.estaVivo());
    }
}