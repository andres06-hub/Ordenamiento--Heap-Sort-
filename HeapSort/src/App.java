import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    
    static String separador = "------------------------------------------------------";

    static long hora = 3600000;
    static long minutos = 60000;
    static long segundos = 1000;    


    public static void main(String[] args) throws Exception {


        // Variables para calcular el tiempo de todo el programa
        int horaGlobal, minutosGlobal, segundosGlobal;
        long milisegundosTiempoGlobal;

        horaGlobal = 0;
        minutosGlobal = 0;
        segundosGlobal = 0;


        long inicioTiempoGlobal = System.currentTimeMillis();

        // ##########################################################################################
        System.out.print(separador);
        System.out.println("\n\tEl tiempo se estima de la sigiente forma\n\t\tHH/MM/SS/ML\n");
        iniciar();
        
        // ##########################################################################################

        long finTiempoGlobal = System.currentTimeMillis();

        milisegundosTiempoGlobal = finTiempoGlobal - inicioTiempoGlobal;

        // Se captura el tiempo en milisegundos 
        if (milisegundosTiempoGlobal >= hora) {
                while (milisegundosTiempoGlobal >= hora){
                    horaGlobal+= 1;
                    milisegundosTiempoGlobal -= 3600000;    
                }    
            }
            if (milisegundosTiempoGlobal >= minutos) {
                while (milisegundosTiempoGlobal >= minutos) {
                    minutosGlobal +=1;
                    milisegundosTiempoGlobal -= 600000;
                }
            }
            if (milisegundosTiempoGlobal >= segundos) {
                while (milisegundosTiempoGlobal >= segundos) {
                    segundosGlobal +=1;
                    milisegundosTiempoGlobal -= 1000;
                }
            }

        System.out.println("TIEMPO DEL PROGRAMA:");
        System.out.println(horaGlobal+"/"+minutosGlobal+"/"+segundosGlobal+"/"+milisegundosTiempoGlobal);

    }
    


    public static void iniciar(){
        
        // Variables globales
        long inicio, fin, milisegundos;
        int horaTotal, minutosTotal, segundosTotal;

        // Rangos de numeros a generar
        double valorMenor = -1000;
        double valorMayor = 999;


        // Se declara variables
        String nombreUsuario = "Default";
        int cantidadNumeros = 0;

        // Numeros generados
        ArrayList<Double> numerosGene = new ArrayList<>();

        
        // Arraylist que permite guardar los datos leidos 
        ArrayList<Double> numerosLeidos = new ArrayList<>();

        // ArrayList con los datos ordenados que obtibimos anteriorente
        // Head Sort
        ArrayList<Double> numerosOrdenados = new ArrayList<>();
        
        /**
         * For para calcularme el tiempo por cada 
         * funcionamiento del programa
         */

        for (int i = 1; i < 6; i++) {
            
            // Se declaran las variables
            // hora = 3600000;
            // minutos = 60000;
            // segundos = 1000;

            // Las variables para saber cuanto duro en total
            horaTotal = 0;
            minutosTotal = 0;
            segundosTotal = 0;
            
            //Se declara el switch para poder tener un control del tiempó
            // 

            inicio = System.currentTimeMillis();

            switch (i) {
                case 1:
                // Se estima el tiempo 
                // Pidiendo los datos al usuario
                    nombreUsuario = getUsuario();
                    cantidadNumeros = cantidadDatosDesee();

                    break;

                case 2:
                    // Generar numeros aleatorios
                    numerosGene = generarNumero(cantidadNumeros, valorMayor, valorMenor);

                    break;
                    
                case 3:    
                    // Metodo de ArrayList
                    // Escribir en un archivo
                    FileWhrite(numerosGene, nombreUsuario);

                    break;

                case 4:
                    // Leer archivo creado anteriormente
                    readerFile(cantidadNumeros, numerosLeidos);

                    break;

                case 5:
                    // Ordenamiento de datos en la estructura de datos
                    // De menor a mayor
                    // Heap sort    



                    break;
                default:
                    break;
            } 
            
            
            fin = System.currentTimeMillis();    

            // Se captura el tiempo en milisegundos 
            milisegundos = fin - inicio;
        
            if (milisegundos >= hora) {
                while (milisegundos >= hora){
                    horaTotal += 1;
                    milisegundos -= 3600000;    
                }    
            }
            if (milisegundos >= minutos) {
                while (milisegundos >= minutos) {
                    minutosTotal +=1;
                    milisegundos -= 600000;
                }
            }
            if (milisegundos >= segundos) {
                while (milisegundos >= segundos) {
                    segundosTotal +=1;
                    milisegundos -= 1000;
                }
            }

            
            System.out.println("#################################################");
            System.out.println((i)+" ) "+horaTotal+"/"+minutosTotal+"/"+segundosTotal+"/"+milisegundos);
            

        }


        
        // Conversion de nanosegundo a segundos
        // double diferencia = (double) (fin - inicio) * 1.0e-9;
        
        // System.out.print("segundos "+diferencia+" s");

        
        System.out.println(numerosLeidos);
        
        System.out.println("Ordenados"+numerosOrdenados);
        // Se vacia el arreglo
        numerosLeidos.clear();
        System.out.println(numerosLeidos);
    }



    // Funcion que pide cuantos datos requiere el usuario
    public static int cantidadDatosDesee(){
        // Se le pide cuantos datos requiere el usuario
        // Cuantos numeros requeire en aleatorio
        int date = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos datos desea?"));
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
            // System.out.println(numRedondeado);
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
                // int i = 0;
                for (Double numAleatorio : numerosGene) {

                    // linea.println((i + 1) + " ) " + numAleatorio);
                    // i += 1;
                    linea.println(numAleatorio);
                }

                linea.println("--------------------------------------");
                // Cerramos la escritura en linea
                linea.close();
                escribir.close();

            } catch (Exception e) {

            }
            
        }else{
            
            // Eliminamos el Archivo existente
            archivo.delete();

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
                // int i = 0;
                for (Double numAleatorio : numerosGene) {

                    // linea.println((i + 1) + " ) " + numAleatorio);
                    // i += 1;
                    linea.println(numAleatorio);
                }

                linea.println("--------------------------------------");
                // Cerramos la escritura en linea
                linea.close();
                escribir.close();

            } catch (Exception e) {

            }
        } 
    }


    // Leer los datos del archivo
    public static void readerFile(int cantidadNumeros, ArrayList<Double> numerosLeidos){

        // El archivo de texto que ya esta creado 
        File archivo;
        // leer el archivo creado
        FileReader leer;
        // En donde se almacena la nlinea del archivo, el dato que contiene la linea
        BufferedReader almacenaLinea;
        // se crea variable p'ara guardar el dato obtenido
        String dato;

        // Se crea la intancia para poder acceder al archivo de txt
        archivo = new File("usuarioNumeros.txt");

        try {
            // Intanciamos la variable leer
            leer = new FileReader(archivo);
            // Se intsacia la variabale para poder pasar por cada linea
            almacenaLinea = new BufferedReader(leer);

            for (int i = 0; i < (cantidadNumeros + 4); i++) {

                try {

                    dato = almacenaLinea.readLine();
                    //  Se pasa el dato al ArrayList
                    numerosLeidos.add(Double.parseDouble(dato));
                    
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }     

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
