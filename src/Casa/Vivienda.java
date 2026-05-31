/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Casa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magal
 */
public class Vivienda implements Serializable{
    
    private List<Habitacion> habitaciones;
    private String historialAcumulado = "";
    
    public Vivienda(){
        this.habitaciones=new ArrayList<>();
    }
    public String getHistorialAcumulado() {
        return this.historialAcumulado;
    }
    
    public void setHistorialAcumulado(String historialAcumulado) {
        this.historialAcumulado = historialAcumulado;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    public void agregarHabitacion(Habitacion h) { 
    this.habitaciones.add(h); 
}
    
    
}
