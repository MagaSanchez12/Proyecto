/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import Dispositivo.AireAcondicionado;
import Dispositivo.Dispositivo;
import InterfazGrafica.VentanaPrincipal;


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
        for (Dispositivo d : habitacion.getDispositivos()) {
            if (d instanceof AireAcondicionado) {   
                if (!((AireAcondicionado) d).estaEncendido() || ((AireAcondicionado) d).getTemperatura() != 23.0){
                d.encender();                 
                ((AireAcondicionado) d).setTemperatura(23.0);                
                d.ejecutarAccion(); 
                VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Sensor '" + getNombre() + "' detectó calor de " + tempAmbiente + "°C. Prendiendo aire acondicionado en 23°C.");
                }

            }
        }
    }
    else {
        for (Dispositivo d : habitacion.getDispositivos()) {
            if (d instanceof AireAcondicionado && d.estaEncendido()) {
                d.apagar();
                VentanaPrincipal.instanciaGlobal.registrarEnHistorial("Clima agradable en " + habitacion.getNombre() + ". Apagando aire acondicionado.");
            }
        }
    }
}
}
