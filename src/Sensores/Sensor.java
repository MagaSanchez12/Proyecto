/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sensores;

import Casa.Habitacion;
import java.io.Serializable;

/**
 *
 * @author magal
 */
public abstract class Sensor implements Serializable{
    private String nombre;
    private String id;
    private boolean estadoAlerta;

    public Sensor(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.estadoAlerta = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean isEstadoAlerta() {
        return estadoAlerta;
    }
    

    public void setEstadoAlerta(boolean estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }
    
    public abstract void evaluar(Habitacion habitacion);
    
   
    
    
    
    
}
