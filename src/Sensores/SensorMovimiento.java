/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.Dispositivo;
import Dispositivo.Luz;


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
                        if(!(d.estaEncendido())|| ((Luz)d).getIntensidad() != 10){
                        System.out.println("Movimiento detectado en" + habitacion.getNombre());
                        ((Luz)d).encender();
                        ((Luz)d).setIntensidad(10);}
                        d.ejecutarAccion();
                    }else{
                        ((Luz)d).setIntensidad(100);
                    }
                }
            }
        }else{
            for(Dispositivo d: habitacion.getDispositivos()){
                if(d instanceof Luz && d.estaEncendido()){
                    d.apagar();
                }
            }
        }
    }
    
   
    }
    

