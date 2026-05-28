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

    private double tempAmbiente; 

    public SensorTemperatura(String nombre, String id) {
        super(nombre, id);
        this.tempAmbiente = 20.0; // Temp inicial por defecto
    }
    public void setTempAmbiente(double tempAmbiente) {
        this.tempAmbiente = tempAmbiente;
    }

    public double getTemperaturaAmbiental() {
        return tempAmbiente;
    }

    @Override
    public void evaluar(Habitacion habitacion) {
    if (this.tempAmbiente > 28.0) {
        System.out.println("Sensor '" + getNombre() + "' detectó calor de " + tempAmbiente + "°C.");
        
        for (Dispositivo d : habitacion.getDispositivos()) {
            if (d instanceof AireAcondicionado) {   
                if (!((AireAcondicionado) d).estaEncendido() || ((AireAcondicionado) d).getTemperatura() != 18.0)
                d.encender();                 
                ((AireAcondicionado) d).setTemperatura(23.0);                
                d.ejecutarAccion(); 
            }
        }
    }
    else {
        for (Dispositivo d : habitacion.getDispositivos()) {
            if (d instanceof AireAcondicionado && d.estaEncendido()) {
                d.apagar();
                System.out.println("Clima agradable en " + habitacion.getNombre() + ". Apagando aire acondicionado.");
            }
        }
    }
}
}
