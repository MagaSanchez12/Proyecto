/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispositivo;

import Interfaces.ConsumoEnergia;

/**
 *
 * @author magal
 */
public class AireAcondicionado extends Dispositivo implements ConsumoEnergia{
    private double temperatura;

    public AireAcondicionado(String nombre, String id) {
        super(nombre, id, 1.5); //consumo de fabrrica 1.5kWh
        this.temperatura = 24.0; //ideal 
    }

    public double getTemperatura() {
        return temperatura;
    }
    

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    @Override 
     public double obtenerConsumoActual(){
         if(!estado){return 0.0;} 
         if(this.temperatura <20){
             return consumoEnergia*1.5; //gasta mas para enfriar
         }
         if(this.temperatura>24){
             return consumoEnergia*0.8; //gasta menos, ahorra energia
         }
         else{return consumoEnergia;}
     }
    @Override 
    public void ejecutarAccion(){
        System.out.println(getNombre( )+ "cambiando a"+ temperatura +"°C.");
        
    }
    
    
}
