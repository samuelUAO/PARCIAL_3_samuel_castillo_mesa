/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;
import java.util.ArrayList;
/**
 *
 * @author SAMUEL
 */
public class Jugador extends Persona {

    public static final int MAX_LP = 8000;

    private int puntosVida;
    private ArrayList<Monstruo> monstruos;

    public Jugador(String nombre, String identificacion) {
        super(nombre, identificacion);
        this.puntosVida = MAX_LP;
        this.monstruos = new ArrayList<>();
    }

    public void recibirDanio(int danio) {
        if (danio > 0) {
            puntosVida -= danio;

            if (puntosVida < 0) {
                puntosVida = 0;
            }
        }
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public void agregarMonstruo(Monstruo monstruo) {
        if (monstruo != null && monstruos.size() < 5) {
            monstruos.add(monstruo);
        }
    }

    public ArrayList<Monstruo> getMonstruos() {
        return monstruos;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    @Override
    public String mostrarDatos() {
        return "Jugador: " + nombre
                + " | LP: " + puntosVida
                + " | Monstruos: " + monstruos.size();
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}
// Representa los datos y características de un monstruo.
