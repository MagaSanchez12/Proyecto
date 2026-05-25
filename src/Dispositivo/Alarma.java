/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispositivo;

/**
 *
 * @author magal
 */
public class Alarma extends Dispositivo{

    public Alarma(String nombre, String id, double consumoEnergia) {
        super(nombre, id, consumoEnergia);
    }
    
    public void activarAlarma(){
        this.estado= true;
        System.out.println("ALARMA DE EMERGENCIA!" + getNombre()+ "ESTA SONANDO");
    }
    
    public void desactivarAlarma(){
        this.estado= false;
        System.out.println("Alarma" + getNombre()+ "desactivada");
    }
    @Override
    public void apagar(){desactivarAlarma();}

    @Override
    public void encender(){activarAlarma();}

    @Override
    public boolean estaEncendido(){return this.estado;}
    
    @Override 
    public void ejecutarAccion(){
        if(this.estado){ 
            desactivarAlarma();
        }else{ activarAlarma();} 
    }
    
}
