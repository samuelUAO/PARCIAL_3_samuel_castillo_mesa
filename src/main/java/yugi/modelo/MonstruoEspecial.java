/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yugi.modelo;

/**
 *
 * @author SAMUEL
 */
public class MonstruoEspecial extends Monstruo {

    private String habilidad;

    public MonstruoEspecial() {
        super("Mago Oscuro", 2500, 2100);
        this.habilidad = "Poder mágico";
    }

    public String activarHabilidad() {
        return nombre + " activa: " + habilidad;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Habilidad: " + habilidad;
    }
}
