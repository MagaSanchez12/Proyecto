/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Casa;

import Dispositivo.Dispositivo;
import Sensores.Sensor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author magal
 */
public class Habitacion implements Serializable{
    private String nombre;
    private List<Dispositivo> dispositivos;
    private List<Sensor> sensores;

    public Habitacion(String nombre, List<Dispositivo> dispositivos, List<Sensor> sensores) {
        this.nombre = nombre;
        this.dispositivos = dispositivos;
        this.sensores = sensores;
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





    
    
    
}
