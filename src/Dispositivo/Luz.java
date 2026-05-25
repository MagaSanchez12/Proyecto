/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispositivo;

/**
 *
 * @author magal
 */
public class Luz extends Dispositivo{
    private int intensidad;//0-100

    public Luz(String nombre, String id, double consumoEnergia) {
        super(nombre, id, consumoEnergia);
        this.intensidad = 100;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }
    @Override
     public double obtenerConsumoActual(){
         if(!encendido){return 0.0;}
         return this.consumoEnergia*(intensidad/100.0);    
     } 
     @Override
     public void ejecutarAccion(){
         System.out.println(getNombre()+ "regulada al"+ intensidad + "% de intensidad");
     }
     
   
}
