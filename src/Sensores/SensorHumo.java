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
            System.out.println("PELIGRO DE INCENDIO: Detectado por"+ getNombre()+ "en"+ habitacion.getNombre());
            for (Dispositivo d : habitacion.getDispositivos()){
                if(d instanceof Alarma){
                    ((Alarma)d).activarAlarma();
                }
                if(d instanceof Ventana){
                    ((Ventana)d).abrir(); //para que salga el humo y la gente no se ahogue (?
                
            }
            }
        }
        
    }
    
}
