/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Casa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author magal
 */
public class Archivo {// si hay apagones se recuperara el estado de la casa
    private static final String ARCHIVO= "registro_casa";
    public static void guardarCasa(Vivienda vivienda){
        try(ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream(ARCHIVO))){
            salida.writeObject(vivienda);
            System.out.println("Datos respaldados con exito"); 
        }catch(IOException e){
            System.out.println("Error:"+e.getMessage());
        }       
    }
    
    public static Vivienda cargarCasa(){
        File archivo= new File(ARCHIVO);
        if(!archivo.exists()){
            System.out.println("No hay respaldo previo. Creanco casa vacia...");
            return new Vivienda();}
        try(ObjectInputStream entrada= new ObjectInputStream(new FileInputStream(archivo))){   
            System.out.println("Recuperando estado de la casa...");
            return (Vivienda)entrada.readObject();           
        } catch(IOException| ClassNotFoundException e){
            System.out.println("Error:"+ e.getMessage()+".Iniciando casa vacia...");
            return new Vivienda();
        }
    }
    
}
