/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;

/**
 *
 * @author SAMUEL
 */
public class Combate {

    private int turno;
    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;
    private Historial historial;
    private int ultimoDanio;
    private String ultimoReporte;

    public Combate(Jugador atacante, Jugador defensor) {
        this.jugadorAtacante = atacante;
        this.jugadorDefensor = defensor;
        this.historial = new Historial();
        this.turno = 1;
        this.ultimoDanio = 0;
        this.ultimoReporte = "";
    }

    public String ejecutarCombate(Monstruo atacante, Monstruo defensor) {

        if (atacante == null || !jugadorAtacante.getMonstruos().contains(atacante)) {
            return "El monstruo atacante no pertenece al jugador atacante.";
        }

        if (!jugadorAtacante.estaVivo() || !jugadorDefensor.estaVivo()) {
            return "El combate ha terminado.";
        }

        ultimoDanio = 0;
        String resultado;

        // Ataque directo
        if (defensor == null) {

            if (!jugadorDefensor.getMonstruos().isEmpty()) {
                return "No puedes atacar directamente: el rival tiene monstruos.";
            }

            ultimoDanio = atacante.getAtaque();
            jugadorDefensor.recibirDanio(ultimoDanio);

            resultado = "Ataque directo. "
                    + jugadorDefensor.getNombre()
                    + " pierde " + ultimoDanio + " LP.";

        } else {

            if (!jugadorDefensor.getMonstruos().contains(defensor)) {
                return "El monstruo defensor no pertenece al rival.";
            }

            if (defensor.getPosicion().equals("ATAQUE")) {

                int diferencia = atacante.getAtaque() - defensor.getAtaque();

                if (diferencia > 0) {
                    jugadorDefensor.getMonstruos().remove(defensor);
                    jugadorDefensor.recibirDanio(diferencia);
                    ultimoDanio = diferencia;

                    resultado = "El monstruo defensor fue destruido. "
                            + jugadorDefensor.getNombre()
                            + " pierde " + diferencia + " LP.";

                } else if (diferencia < 0) {
                    jugadorAtacante.getMonstruos().remove(atacante);
                    jugadorAtacante.recibirDanio(-diferencia);
                    ultimoDanio = -diferencia;

                    resultado = "El monstruo atacante fue destruido. "
                            + jugadorAtacante.getNombre()
                            + " pierde " + (-diferencia) + " LP.";

                } else {
                    jugadorAtacante.getMonstruos().remove(atacante);
                    jugadorDefensor.getMonstruos().remove(defensor);

                    resultado = "Ambos monstruos fueron destruidos.";
                }

            } else {

                int diferencia = atacante.getAtaque() - defensor.getDefensa();

                if (diferencia > 0) {
                    jugadorDefensor.getMonstruos().remove(defensor);

                    resultado = "El monstruo defensor fue destruido. No hay daño a LP.";

                } else if (diferencia < 0) {
                    jugadorAtacante.recibirDanio(-diferencia);
                    ultimoDanio = -diferencia;

                    resultado = jugadorAtacante.getNombre()
                            + " pierde " + (-diferencia) + " LP. "
                            + "El monstruo defensor sobrevive.";

                } else {
                    resultado = "Los puntos son iguales. Ningún monstruo fue destruido.";
                }
            }
        }

        ultimoReporte = "Turno " + turno
                + " | Atacante: " + atacante.getNombreMonstruo()
                + " | Defensor: "
                + (defensor == null ? "Ataque directo" : defensor.getNombreMonstruo())
                + " | Daño: " + ultimoDanio
                + " | Resultado: " + resultado;

        historial.guardarRegistro(ultimoReporte);
        turno++;

        return ultimoReporte;
    }

    public int calcularDanio() {
        return ultimoDanio;
    }

    public String generarReporte() {
        return ultimoReporte;
    }
}
