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

    public Dispositivo(String nombre, String id, boolean estado, double consumoEnergia) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
        this.consumoEnergia = consumoEnergia;
    }
    
    
    
}
//