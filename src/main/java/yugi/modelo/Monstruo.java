/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;

/**
 *
 * @author SAMUEL
 */
public class Monstruo extends Carta implements Combatible {

    protected String posicion;

    public Monstruo(String nombre, int ataque, int defensa) {
        super(nombre, ataque, defensa);
        this.posicion = "ATAQUE";
    }

    @Override
    public String atacar() {
        return nombre + " está listo para atacar.";
    }

    // Sobrecarga del método atacar
    public String atacar(Monstruo objetivo) {
        if (objetivo == null) {
            return "No hay un monstruo objetivo.";
        }

        return nombre + " ataca a " + objetivo.nombre;
    }

    @Override
    public String mostrarInformacion() {
        return "Monstruo: " + nombre
                + " | ATK: " + ataque
                + " | DEF: " + defensa
                + " | Posición: " + posicion;
    }

    public void cambiarPosicion(String nuevaPosicion) {
        if (nuevaPosicion != null &&
            (nuevaPosicion.equalsIgnoreCase("ATAQUE")
            || nuevaPosicion.equalsIgnoreCase("DEFENSA"))) {

            posicion = nuevaPosicion.toUpperCase();
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getNombreMonstruo() {
        return nombre;
    }
}
