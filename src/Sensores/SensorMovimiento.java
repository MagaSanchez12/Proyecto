/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.Dispositivo;
import Dispositivo.Luz;
import InterfazGrafica.VentanaPrincipal;


/**
 *
 * @author magal
 */
public class SensorMovimiento extends Sensor {

    public SensorMovimiento(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void evaluar(Habitacion habitacion) {
        int horaActual= habitacion.getHora();
        if(this.isEstadoAlerta()){
            for(Dispositivo d : habitacion.getDispositivos()){
                if(d instanceof Luz){
                    if(horaActual>=0 && horaActual<=6){
                        VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Movimiento de madrugada: Encendiendo luces reguladas en " + habitacion.getNombre());
                        if(!(d.estaEncendido())|| ((Luz)d).getIntensidad() != 10){
                            ((Luz)d).encender();
                            ((Luz)d).setIntensidad(10);
                        }
                    d.ejecutarAccion();
                    }else{
                        if(!(d.estaEncendido()) || ((Luz)d).getIntensidad() != 100){
                        ((Luz)d).encender();
                        ((Luz)d).setIntensidad(100);
                        d.ejecutarAccion();
                        VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Movimiento de dia: Encendiendo luces al 100 en " + habitacion.getNombre());

                        }
                    }
                }
            }
        }else{
            for(Dispositivo d: habitacion.getDispositivos()){
                if(d instanceof Luz && d.estaEncendido()){
                    d.apagar();
                    VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Sin movimiento detectado: Apagando luces en " + habitacion.getNombre());
                }
            }
        }
    }
    
   
    }
    

