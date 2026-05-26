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

    public Ventana(String nombre, String id, double consumoEnergia) {
        super(nombre, id, consumoEnergia);
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
        if(this.estado){ // si esta abierta (true) se cierra
            cerrar();
        }else{ abrir();} // si esta cerrada (false) se abre
    }
    
    
    
}
