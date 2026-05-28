/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Casa;

import Dispositivo.Dispositivo;
import Sensores.Sensor;
import Sensores.SensorHumo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magal
 */
public class Habitacion implements Serializable{
    private String nombre;
    private List<Dispositivo> dispositivos;
    private List<Sensor> sensores;
    int hora;

    public Habitacion(String nombre) {
        this.nombre = nombre;
        this.dispositivos = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.hora= 12;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public int getHora() {
        return hora;
    }
    

    public void setHora(int hora) {
        if(hora>=0 && hora<=23){
        this.hora = hora;}
    }
    
    public void ejecutarAutomatizaciones(){
        if (this.sensores.isEmpty()) {
        System.out.println( this.nombre + " no tiene sensores instalados.");
        return; 
        } 
        boolean seEjecutoAlgo = false;
        for (Sensor s : this.sensores) {
            s.evaluar(this);
            seEjecutoAlgo = true;
        }

        if (seEjecutoAlgo) {
            System.out.println(" Automatizaciones ejecutadas con exito en " + this.nombre);
        }
    }
    
        public void agregarDispositivo(Dispositivo d) { 
            this.dispositivos.add(d); 
        }
        public void agregarSensor(Sensor s) { 
            this.sensores.add(s); 
        }

    @Override
    public String toString() {
        return "Habitacion{" + "nombre=" + nombre + '}';
    }

  
    
    
    





    
    
    
}
