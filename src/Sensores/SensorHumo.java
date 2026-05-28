/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.Alarma;
import Dispositivo.Dispositivo;
import Dispositivo.Ventana;


/**
 *
 * @author magal
 */
public class SensorHumo extends Sensor{

    public SensorHumo(String nombre, String id) {
        super(nombre, id);
    }


    @Override
    public void evaluar(Habitacion habitacion) {
        if (this.isEstadoAlerta()){
            boolean primeraActivacion = false;
            for (Dispositivo d : habitacion.getDispositivos()){
                if(d instanceof Alarma){
                    if (!d.estaEncendido()) {
                    d.encender();
                    d.ejecutarAccion();
                    primeraActivacion = true;
                }
            }
                if(d instanceof Ventana){
                    if (!d.estaEncendido()) { 
                    d.encender(); 
                    d.ejecutarAccion();   
                }
            }
        }
        
        if (primeraActivacion) {
            System.out.println("ALERTA: Peligro de incendio detectado por " + getNombre() + " en " + habitacion.getNombre() + "!");
        }
        
    } else {
        for (Dispositivo d : habitacion.getDispositivos()) {
            if ((d instanceof Alarma || d instanceof Ventana) && d.estaEncendido()) {
                d.apagar();
                d.ejecutarAccion(); 
            }
        }
    }
}
}