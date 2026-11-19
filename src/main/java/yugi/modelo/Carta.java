/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;

/**
 *
 * @author SAMUEL
 */
public abstract class Carta {

    protected String nombre;
    protected int ataque;
    protected int defensa;

    public Carta(String nombre, int ataque, int defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract String mostrarInformacion();
}