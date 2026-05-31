/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.* ;
import InterfazGrafica.VentanaPrincipal;


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
            VentanaPrincipal.instanciaGlobal.registrarEnHistorial("ALERTA: Peligro de incendio detectado por " + getNombre() + " en " + habitacion.getNombre());
            for (Dispositivo d : habitacion.getDispositivos()){
                if(d instanceof Alarma){
                    if (!d.estaEncendido()) {
                    d.encender();
                    VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Alarma "+ d.getNombre() + " de " + habitacion.getNombre() + " ACTIVADA.");
                }
            }
                if(d instanceof Ventana){
                    if (!d.estaEncendido()) { 
                    d.encender();
                    VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Ventana de " + habitacion.getNombre() + " Abierta automaticamente para ventilar.");  
                    
                }
            }
                
                if (d instanceof Luz || d instanceof AireAcondicionado) {
                    if (d.estaEncendido()) {
                        d.apagar();
                        VentanaPrincipal.instanciaGlobal.registrarEnHistorial("CORTE DE EMERGENCIA: " + d.getNombre() + " en " + habitacion.getNombre() + " fue apagado para prevenir cortocircuitos.");
                    }
                }
        }
        
    } else {
        for (Dispositivo d : habitacion.getDispositivos()) {
            if ((d instanceof Alarma || d instanceof Ventana) && d.estaEncendido()) {
                d.apagar();
                d.ejecutarAccion(); 
                VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Emergencia finalizada en" + habitacion.getNombre()+ ": Alarmas apagadas y ventanas cerradas.");
            }
        }
    }
}
}