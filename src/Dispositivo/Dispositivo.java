/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispositivo;

import Interfaces.Activable;

/**
 *
 * @author magal
 */
public abstract class Dispositivo implements Activable{
    protected String nombre;
    protected String id;
    protected boolean estado;
    protected double consumoEnergia;

    public Dispositivo(String nombre, String id, double consumoEnergia) {
        this.nombre = nombre;
        this.id = id;
        this.estado = false;
        this.consumoEnergia = consumoEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean estaEncendido(){return this.estado;}

    @Override
    public void apagar(){this.estado= true;}

    @Override
    public void encender(){this.estado=false;}  
    
    public abstract void ejecutarAccion();
    
}
//