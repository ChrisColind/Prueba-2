/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortareas;

import java.util.Scanner;

/**
 *
 * @author Rogelio
 */
public class GestorTareas{
 
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        int opcion = 0;
 
        do{
            System.out.println("\nGESTOR DE TAREAS");
            System.out.println("================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Completar tareas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
 
            try{
                opcion = n.nextInt();
                n.nextLine();
 
                if(opcion== 1){
                    System.out.print("Ingresa la nueva tarea: ");
                    String tarea = n.nextLine();
                    Tareas.agregarTarea(tarea);
 
                }else if(opcion == 2){
                    Tareas.mostrarTareas();
 
                }else if(opcion == 3){
                    if(Tareas.leerTareas().isEmpty()){
                        System.out.println("No hay tareas para completar.");
                    }else{
                        Tareas.mostrarTareas();
                        System.out.print("Elija la tarea para completar: ");
                        int numero = n.nextInt();
                        n.nextLine();
                        Tareas.completarTarea(numero);
                    }
 
                }else if(opcion!=4){
 
                }
 
            }catch(Exception e){
                System.out.println("Opcion no valida");
                n.nextLine();
                opcion = 0;
            }
 
        }while(opcion !=4);
 
        n.close();
    }
}