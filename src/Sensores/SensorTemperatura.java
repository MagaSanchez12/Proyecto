/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.AireAcondicionado;
import Dispositivo.Dispositivo;


/**
 *
 * @author magal
 */
public class SensorTemperatura extends Sensor{

    public SensorTemperatura(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void evaluar(Habitacion habitacion) {
        if(this.isEstadoAlerta()){
        for (Dispositivo d : habitacion.getDispositivos()){
                if(d instanceof AireAcondicionado){
                    ((AireAcondicionado)d).encender();
                
            }
        }
    }
    }


    
}
