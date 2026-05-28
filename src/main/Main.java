/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Casa.*;
import Dispositivo.*;
import Interfaces.ConsumoEnergia;
import Sensores.*;
import java.util.Scanner;

/**
 *
 * @author magal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        
        Vivienda casita= Archivo.cargarCasa();
        
        int opcion = 0;
        do {
            System.out.println("===  PANEL DE CONTROL  ===");
            System.out.println("1. Ver estado de la casa");
            System.out.println("2. Crear una nueva Habitacion");
            System.out.println("3. Agregar un Dispositivo (Luz, Aire, Ventana, Alarma)");
            System.out.println("4. Agregar un Sensor (Movimiento, Temperatura, Humo)");
            System.out.println("5. Ver alertas en sensores"); 
            System.out.println("6. Calcular consumo energetico");
            System.out.println("7. Guardar cambios y salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpia el buffer

            switch (opcion) {
                case 1:
                    if (casita.getHabitaciones().isEmpty()) {
                        System.out.println(" La casa esta vacia. Crea una habitacion!");
                    } else {
                        for (Habitacion h : casita.getHabitaciones()) {
                            System.out.println(" Habitacion: " + h.getNombre());
                            System.out.println("  [Dispositivos]");
                            if (h.getDispositivos().isEmpty()) System.out.println("No hay dispositivos registrados");
                            for (Dispositivo d : h.getDispositivos()) {
                                System.out.println("Dispositivo: " + d.getNombre() + " [ID: " + d.getId()+ "] -> Estado: "+d.estaEncendido());
                             
                            }
                            
                            System.out.println("  [Sensores]");
                            if (h.getSensores().isEmpty()) System.out.println("No hay sensores registrados");
                            for (Sensor s : h.getSensores()) {
                                System.out.println("Sensor: " + s.getNombre() + " [ID: " + s.getId() + "] -> Alerta: " + (s.isEstadoAlerta() ? "SI" : "NO"));
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de la habitacion: ");
                    String nombreH = teclado.nextLine();
                    casita.agregarHabitacion(new Habitacion(nombreH));
                    System.out.println("Habitacion: " + nombreH + "creada con exito.");
                    break;

                case 3:
                    if (casita.getHabitaciones().isEmpty()) {
                        System.out.println("Primero debes crear una habitacion.");
                        break;
                    }
                    System.out.println("Seleccione el numero de la habitacion donde instalara el dispositivo:");
                    for (int i = 0; i < casita.getHabitaciones().size(); i++) {
                        System.out.println(i + casita.getHabitaciones().get(i).getNombre());
                    }
                    int numHab = teclado.nextInt();
                    teclado.nextLine();
                    if (numHab < 0 || numHab >= casita.getHabitaciones().size()) {
                        System.out.println("Numero de habitacion invalido. Volviendo al menu principal...");
                          break;
                    }
                    System.out.println("Que dispositivo desea instalar?");
                    System.out.println("1 Luz \n2 Aire Acondicionado\n3 Ventana\n4 Alarma");
                    int tipoDispositivo = teclado.nextInt();
                    teclado.nextLine(); 
                    
                    System.out.print("Nombre del dispositivo: ");
                    String nomDisp = teclado.nextLine();
                    System.out.print("ID: ");
                    String idDisp = teclado.nextLine();
                    
                    Habitacion habDispDestino = casita.getHabitaciones().get(numHab);
                    
                    if (tipoDispositivo == 1) {
                        habDispDestino.agregarDispositivo(new Luz(nomDisp, idDisp));
                        System.out.println("Luz instalada.");
                    } else if (tipoDispositivo == 2) {
                        habDispDestino.agregarDispositivo(new AireAcondicionado(nomDisp, idDisp));
                        System.out.println("Aire Acondicionado instalado.");
                    } else if (tipoDispositivo == 3) {
                        habDispDestino.agregarDispositivo(new Ventana(nomDisp, idDisp));
                        System.out.println("Ventana registrada.");
                    } else if (tipoDispositivo == 4) {
                        habDispDestino.agregarDispositivo(new Alarma(nomDisp, idDisp));
                        System.out.println("Alarma instalada.");
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                    break;

                case 4:
                    if (casita.getHabitaciones().isEmpty()) {
                        System.out.println("Primero debes crear una habitacion.");
                        break;
                    }
                    System.out.println("Seleccione el numero de la habitacion donde instalara el sensor:");
                    for (int i = 0; i < casita.getHabitaciones().size(); i++) {
                        System.out.println(i + casita.getHabitaciones().get(i).getNombre());
                    }
                    int numHabi = teclado.nextInt();
                    if (numHabi < 0 || numHabi >= casita.getHabitaciones().size()) {
                        System.out.println("Numero de habitacion invalido. Volviendo al menu principal...");
                          break;
                    }
                    System.out.println("Que tipo de sensor desea instalar?");
                    System.out.println("1 Sensor de Movimiento\n2 Sensor de Temperatura\n3 Sensor de Humo");
                    int tipoSensor = teclado.nextInt();
                    teclado.nextLine(); 
                    
                    System.out.print("Nombre para el sensor: ");
                    String nomSens = teclado.nextLine();
                    System.out.print("ID: ");
                    String idSens = teclado.nextLine();
                    
                    Habitacion habSensDestino = casita.getHabitaciones().get(numHabi);
                    
                    if (tipoSensor == 1) {
                        habSensDestino.agregarSensor(new SensorMovimiento(nomSens, idSens));
                        System.out.println("Sensor de Movimiento instalado.");
                    } else if (tipoSensor == 2) {
                        habSensDestino.agregarSensor(new SensorTemperatura(nomSens, idSens));
                        System.out.println("Sensor de Temperatura instalado.");
                    } else if (tipoSensor == 3) {
                        habSensDestino.agregarSensor(new SensorHumo(nomSens, idSens));
                        System.out.println("Sensor de Humo instalado.");
                    } else {
                        System.out.println("Tipo de sensor no valido.");
                    }
                    break;

                case 5:
                    if (casita.getHabitaciones().isEmpty()) {
                        System.out.println("No hay habitaciones creadas.");
                        break;
                    }
                    System.out.println("Vemos entorno actual:");
                    

                    System.out.println("Seleccione la habitacion donde ocurrira el evento:");
                    for (int i = 0; i < casita.getHabitaciones().size(); i++) {
                        System.out.println(i + casita.getHabitaciones().get(i).getNombre());
                    }
                    int idxH = teclado.nextInt();
                    if (idxH < 0 || idxH >= casita.getHabitaciones().size()) {
                        System.out.println("Selección invalida.");
                        break;
                    }
                    Habitacion habEvento = casita.getHabitaciones().get(idxH);
                    
                    System.out.println("1 Hay movimiento)");
                    System.out.println("2 Cambio la temperatura)");
                    System.out.println("3 Se detecto humo)");
                    int tipoEv = teclado.nextInt();
                    boolean eventoValido = true;
                       
                    if (tipoEv == 1) {
                        System.out.print("Que hora es? (0-23): ");
                        int horaActual = teclado.nextInt();
            
                        for (Habitacion h : casita.getHabitaciones()) {
                        h.setHora(horaActual);
                        }
                        System.out.print("Hay personas moviendose ahora? (1 = SI, 2 = NO): ");
                        int mov = teclado.nextInt();
       
                        for (Sensor s : habEvento.getSensores()) {
                            if (s instanceof SensorMovimiento) {
                                s.setEstadoAlerta(mov == 1);}// true si toca 1, false si toca 2
                        }
                    } else if (tipoEv == 2) {
                        System.out.print("Ingrese la temperatura de esta sala (C): ");
                        double t = teclado.nextDouble();
                        for (Sensor s : habEvento.getSensores()) {
                            if (s instanceof SensorTemperatura) {
                                ((SensorTemperatura) s).setTempAmbiente(t);}
                            }
                    } else if (tipoEv == 3) {
                        System.out.print("Se detecta humo en esta habitacion? (1 = SI, 2 = NO): ");
                        int hu = teclado.nextInt();
                        for (Sensor s : habEvento.getSensores()) {
                            if (s instanceof SensorHumo) s.setEstadoAlerta(hu == 1);
                        }
                    } else {
                        System.out.println("Opcion de evento invalida.");
                        eventoValido = false;
                    }   
                        
                    if (eventoValido) {   
                    System.out.println(" Analizando todos los sensores de la casa...");
                    for (Habitacion h : casita.getHabitaciones()) {
                        System.out.println("Evaluando: " + h.getNombre() + "...");
                        h.ejecutarAutomatizaciones(); 
                    }
                    System.out.println("Casa actualizada correctamente.");
                    }
                    break;
          

                case 6:
                    if (casita.getHabitaciones().isEmpty()) {
                        System.out.println("No hay habitaciones registradas para calcular consumo.");
                        break;
                    }
                    
                    double consumoTotalCasa = 0.0;
                    System.out.println("--- REPORTE DE CONSUMO ENERGETICO ---");
                    for (Habitacion h : casita.getHabitaciones()) {
                        double consumoHabitacion = 0.0;
                        System.out.println("Habitacion: " + h.getNombre());
                        for (Dispositivo d : h.getDispositivos()) {
                            if (d instanceof ConsumoEnergia) {
                                double gastoAparato = ((ConsumoEnergia) d).obtenerConsumoActual();
                                consumoHabitacion += gastoAparato;
                        System.out.println(d.getNombre() + ": " + gastoAparato + " kWh");
                        }
                    }
                    System.out.println("Consumo de " + h.getNombre() + ": " + consumoHabitacion + " kWh");
                    consumoTotalCasa += consumoHabitacion;
                    }
                    System.out.println("CONSUMO TOTAL ACTUAL DE LA VIVIENDA: " + consumoTotalCasa + " kWh");
                    break;
                case 7:    
                    Archivo.guardarCasa(casita);
                    System.out.println("Saliendo del Panel, respaldo asegurado.");
                    break;
                    
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 7);
        teclado.close();    
    }
}
    
