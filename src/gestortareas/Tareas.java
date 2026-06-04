/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortareas;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Rogelio
 */
public class Tareas{
 
    public static String archivo = "tareas.txt";
 
    public static ArrayList<String> leerTareas(){
        ArrayList<String> lista = new ArrayList<>();
 
        File a = new File(archivo);
        if (!a.exists()){
            return lista;
        }
 
        try{
            FileReader Areader = new FileReader(archivo);
            String linea = "";
            int c;
 
            while ((c = Areader.read()) != -1){
                char car = (char) c;
                if(car == '\n') {
                    if (!linea.isEmpty()){
                        lista.add(linea);
                    }
                    linea = "";
                }else{
                    linea+= car;
                }
            }
 
            if (!linea.isEmpty()) {
                lista.add(linea);
            }
 
            Areader.close();
 
        } catch (Exception e) {
            System.out.println("Error al leer el archivo.");
        }
 
        return lista;
    }
 
    public static void guardarTareas(ArrayList<String> lista) {
        try {
            FileWriter fw = new FileWriter(archivo, false);
 
            for (String tarea : lista) {
                fw.write(tarea + "\n");
            }
 
            fw.close();
 
        }catch(Exception e){
            System.out.println("Error al guardar el archivo.");
        }
    }
 
    public static void agregarTarea(String nombre) {
        ArrayList<String> lista = leerTareas();
        lista.add("[ ] " + nombre);
        guardarTareas(lista);
        System.out.println("\nTarea agregada: " + nombre);
    }
 
    public static void mostrarTareas() {
        ArrayList<String> lista = leerTareas();
 
        System.out.println("\nLISTA DE TAREAS");
        System.out.println("====================");
 
        if (lista.isEmpty()) {
            System.out.println("No hay tareas todavia.");
            return;
        }
 
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
 
    public static void completarTarea(int numero) {
        ArrayList<String> lista = leerTareas();
 
        if (numero < 1 || numero > lista.size()) {
            System.out.println("Numero de tarea invalido.");
            return;
        }
 
        String tarea = lista.get(numero - 1);
 
        if (tarea.startsWith("[✓]")) {
            System.out.println("Esa tarea ya estaba completada.");
            return;
        }
 
        tarea = tarea.replace("[ ]", "[✓]");
        lista.set(numero - 1, tarea);
        guardarTareas(lista);
 
        String nombre = tarea.replace("[x] ", "");
        System.out.println("\nTarea #" + numero + " completada: " + nombre);
    }
}