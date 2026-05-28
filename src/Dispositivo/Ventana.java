/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dispositivo;

/**
 *
 * @author magal
 */
public class Ventana extends Dispositivo{

    public Ventana(String nombre, String id) {
        super(nombre, id, 0.0); //no consume energy
    }
    public void abrir(){
        this.estado= true;
        System.out.println(getNombre()+ "se ha abierto");
    }
    public void cerrar(){
        this.estado= false;
        System.out.println(getNombre()+ "se ha cerrado");
    }
    
    public boolean estaAbierta(){
        return this.estado;
    }
    @Override
    public void apagar(){cerrar();}

    @Override
    public void encender(){abrir();}

    @Override
    public boolean estaEncendido(){return this.estado;}
    
    @Override 
    public void ejecutarAccion(){
        if(this.estado){ 
            abrir();
            System.out.println("Abriendo ventana"+ getNombre());
        }else{ cerrar(); 
            System.out.println("Cerrando ventana"+ getNombre());
        }

    }
    
    
    
}
