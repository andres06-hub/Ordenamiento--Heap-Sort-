import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {

    
    public static void main(String[] args) throws Exception {
        
        iniciar();
        
    }
    
    public static void iniciar(){
        
        // Rangos de numeros a generar
        double valorMenor = -1000;
        double valorMayor = 999;
        // Llamamos nuestras funciones 

         



        String nombreUsuario = getUsuario();
        double cantidadNumeros = cantidadDatosDesee();
        // Metodo de ArrayList
        ArrayList<Double> numerosGene = generarNumero(cantidadNumeros, valorMayor, valorMenor);

        FileWhrite(numerosGene, nombreUsuario);
    }

    // Funcion que pide cuantos datos requiere el usuario
    public static double cantidadDatosDesee(){
        // Se le pide cuantos datos requiere el usuario
        // Cuantos numeros requeire en aleatorio
        double date = Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cuantos datos desea?"));
        return date;
    }

    // Pedimos el nombre de la persona que ingrese los datos
    public static String getUsuario(){

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");
        return nombre;
    }

    // Se crea metodo para generar los numeros y guardarlos en un ArrayList()
    public static ArrayList<Double> generarNumero(double cantidadNumeros, double valorMayor, double valorMenor) {

        ArrayList<Double> listaTemporal = new ArrayList<>();

        // Obtenemos el valor
        for (int i = 0; i < cantidadNumeros; i++) {
            double aleatorio = (Math.random() * (valorMayor - valorMenor) + valorMenor);

            // Se redondea el numero aleatorio que se genera con el isguiente codigo
            double numRedondeado = Math.round(aleatorio * 100.0) / 100.0;
            // Agregamos cada nuemero aleatorio a la lista
            // listaTemporal.add(aleatorio);
            listaTemporal.add(numRedondeado);
            System.out.println(numRedondeado);
        }
        return listaTemporal;
    }

    // Metodo en donde generamos los n numeros en aleatorio
    // los almacenamos en un archivo
    public static void FileWhrite(ArrayList<Double> numerosGene, String nombreUsuario){

        // ##################################
        // Este es para manipular al archivio
        File archivo;
        // Para escribir en el archivo creado
        FileWriter escribir;
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
        archivo =new File("usuarioNumeros.txt");
        
        /**Validamos si el archivo ya exite o no */
        // Si el archivo NO existe 
        if(!archivo.exists()){
            // tratamos de hacer esto
            try {
                // Creamos un archivo nuevo si un archivo  no existe
                archivo.createNewFile();


                // Creamos la istancia de escribir 
                // Le pasamos archivo ya que sera donde se escribira
                /**
                 * true : Es para cuando escriba al final de un archivo
                 *  ya existente, es decir, si un archivo ya tiene datos 
                 * se escribira de bajo de esos datos los nuevos
                 * */
                escribir = new FileWriter(archivo, true);

                // Creamos al intancia para que nos permita escribir con cache
                // Le pasamos 'escribir' ya que linea nos permite escribir ó 
                // tener varias lineas de texto 
                linea = new PrintWriter(escribir);
                
                // Escribimos en el archivo con:
                linea.println("###################################");
                linea.println("Autor : " + nombreUsuario);
                // linea.println("###################################");

                /**
                 * Se pasa por cada uno de los datos guardados en el arreglo
                 * 
                 */
                linea.println("Longitud de elementos creados : " + numerosGene.size() + "\n");
                int i = 0;
                for (Double numAleatorio : numerosGene) {

                    linea.println((i + 1) + " ) " + numAleatorio);
                    i += 1;
                }

                linea.println("--------------------------------------");
                // Cerramos la escritura en linea
                linea.close();
                escribir.close();

            } catch (Exception e) {

            }
            
        }else{
            // Si el archivo ya esta creado
            // tratamos de hacer esto
            try {
               
                // Creamos la istancia de escribir 
                // Le pasamos archivo ya que sera donde se escribira
                /**
                 * true : Es para cuando escriba al final de un archivo
                 *  ya existente, es decir, si un archivo ya tiene datos 
                 * se escribira de bajo de esos datos los nuevos
                 * */
                escribir = new FileWriter(archivo, true);

                // Creamos al intancia para que nos permita escribir con cache
                // Le pasamos 'escribir' ya que linea nos permite escribir ó 
                // tener varias lineas de texto 
                linea = new PrintWriter(escribir);
                
                // Escribimos en el archivo con:
                linea.println("###################################");
                linea.println("Autor : " + nombreUsuario);
                // Se obyengo la cantidad de los numeros generados
                linea.println("Longitud de elementos creados : " + numerosGene.size() + "\n");
                /**
                 * 
                 */
                int i = 0;
                for (Double numAleatorio : numerosGene) {

                    linea.println((i + 1) + ") " + numAleatorio);
                    i += 1;
                }

                linea.println("----------------------------");
                // Cerramos la escritura en linea
                linea.close();
                escribir.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        } 
    }
}
