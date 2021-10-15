import java.io.*;

import javax.swing.JOptionPane;

public class App {

    // Rangos de numeros a generar
    double valorMenor = -1000;
    double valorMayor = 999;

    public static void main(String[] args) throws Exception {
        


    }

    public static void iniciar(){

        // Llamamos nuestras funciones 

        double cantidadNumeros = cantidadDatosDesee();

        FileWhrite(cantidadNumeros);
    }


    // Funcion que pide cuantos datos requiere el usuario
    public static double cantidadDatosDesee(){
        // Se le pide cuantos datos requiere el usuario
        // Cuantos numeros requeire en aleatorio
        double date = Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cuantos datos desea?"));
        return date;
    }

    // Metodo en donde generamos los n numeros en aleatorio
    // los almacenamos en un archivo
    public static void FileWhrite(double cantidadNumeros){

        // ##################################
        // Este es para manipular al archivio
        File archivo;
        // Para escribir en el archivo creado
        FileWrite escribir;
        // Para escribir en el archivo
        PrintWriter linea; 
        /**
         * Se necesita las variables en las cuales queremos pedir 
         * los datos y enviarlos al archivo creado
         * 
         * Datos que se le solicitan al usuario 
         */        
        
        
        
        // Preparando el Archivo
        // Instanciamos el archivo
        archivo =new File("usuario.txt");
        
        /**Validamos si el archivo ya exite o no */
        // Si el archivo NO existe 
        if(!archivo.exists()){
            // tratamos de hacer esto
            try {
                // Creamos un archivo nuevo si un archivo  no existe
                archivo.createNewFile();
                
                
                
            } catch (Exception e) {
                
            }
            
        }else{
            
        }
    }
}
