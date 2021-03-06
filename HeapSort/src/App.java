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

        // Se inicia toomanado el tiempo del programa 
        long inicioTiempoGlobal = System.currentTimeMillis();

        // ##########################################################################################
        // Mensaje de inicio del programa
        System.out.print(separador);
        System.out.println("\n\tBienvenido al programa de ordenamiento\n\t\tHEAD SORT");
        System.out.println("\n\tEl tiempo se estima de la sigiente forma\n\t\tHH/MM/SS/ML\n");
        // Metodo que inicia el programa, llamamos los metodos
        iniciar();
        
        // ##########################################################################################
        
        // Finalizamos el tiempo para calcular el tiempo que toma todo el programa 
        long finTiempoGlobal = System.currentTimeMillis();

        // Se hace la conversion a milisegundos con esta formula
        milisegundosTiempoGlobal = finTiempoGlobal - inicioTiempoGlobal;

        // Se captura el tiempo en milisegundos 
        // Se condiciona para tomar el tiempo en horas
        if (milisegundosTiempoGlobal >= hora) {
                while (milisegundosTiempoGlobal >= hora){
                    horaGlobal+= 1;
                    milisegundosTiempoGlobal -= 3600000;    
                }    
            }
            // Se verifica para tomar el tiempo en 'minutos'
            if (milisegundosTiempoGlobal >= minutos) {
                while (milisegundosTiempoGlobal >= minutos) {
                    minutosGlobal +=1;
                    milisegundosTiempoGlobal -= 600000;
                }
            }
            // Se condiciona y verifica si el tiempo toma segundos
            if (milisegundosTiempoGlobal >= segundos) {
                while (milisegundosTiempoGlobal >= segundos) {
                    segundosGlobal +=1;
                    milisegundosTiempoGlobal -= 1000;
                }
            }
        // Cada ves que se captura el tiempo imprimimos
        // EL tiempo que le tomo al programa en "HH/MM/SS/ML"
        System.out.println("TIEMPO DEL PROGRAMA:");
        System.out.println(horaGlobal+"/"+minutosGlobal+"/"+segundosGlobal+"/"+milisegundosTiempoGlobal);
    }
    
    public static void iniciar(){
        
        // Variables globales

        // para llevar los datos del tiempo
        long inicio, fin, milisegundos;
        int horaTotal, minutosTotal, segundosTotal;

        // Rangos de numeros a generar
        double valorMenor = -1000;
        double valorMayor = 999;


        // Se declara variables
        String nombreUsuario = "Default";
        int cantidadNumeros = 0;

        // Numeros generados, donde se guardan cuando se generan
        ArrayList<Double> numerosGene = new ArrayList<>();

        // Arraylist que permite guardar los datos leidos 
        // En donde se guardan los datos depues de leerlos del file
        ArrayList<Double> numerosLeidos = new ArrayList<>();

        // ArrayList con los datos ordenados que obtuvimos anteriorente
        // Head Sort
        // ArrayList<Double> numerosOrdenados = new ArrayList<>();
        

        /**
         * 
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
            
            // 
            // Se inicia a tomar el tiempo una ves iteres por el primer indice, FORI
            inicio = System.currentTimeMillis();
            
            //Se declara el switch para poder tener un control del tiemp??
            switch (i) {
                case 1:
                // Se estima el tiempo 
                // Pidiendo los datos al usuario

                    // Respuesta que nos dara 
                    String respuesta = "";

                    try {
                        nombreUsuario = getUsuario();
                    } catch (Exception e) {
                        respuesta = "\tXXXX ERROR XXXX";
                    }

                    boolean validacion = true;
                    do {
                        
                        // Se trata de hacer, verificamos si nos da un Error
                        try {
                            // Se lalma la funcion 
                            cantidadNumeros = cantidadDatosDesee();
                            // LA validacion seria se rechaza ya que si se cumple
                            validacion = false;
                            // Si el progrma falla
                        } catch (NumberFormatException e) {
                            respuesta="\t\tXXXXX ERROR XXXXX\nSe han introducido caracteres no num??ricos";
                            System.out.println(respuesta);
                            JOptionPane.showMessageDialog(null, "\t"+respuesta);
                            validacion = true;
                            // break;
                        }
                        // Mientras sea true el ciclo se cumple
                    } while (validacion);

                    System.out.println("Ingreso de datos");
                    break;
                    
                    case 2:
                    // Generar numeros aleatorios
                    try {
                        numerosGene = generarNumero(cantidadNumeros, valorMayor, valorMenor);
                        System.out.println("Numeros Generados - "+numerosGene);    
                        // Si el progrma falla, si hay una excepcion
                    } catch (NumberFormatException e) {
                        respuesta="\t\tXXXXX ERROR XXXXX\nSe han introducido caracteres no num??ricos";
                        System.out.println(respuesta);
                    }
                    break;
                    
                case 3:    
                    // Metodo de ArrayList
                    // Escribir en un archivo
                    FileWhrite(numerosGene, nombreUsuario);
                    System.out.println("Escribir Archivo en txt");

                    break;

                case 4:
                    // Leer archivo creado anteriormente
                    readerFile(cantidadNumeros, numerosLeidos);
                    System.out.println("Leer Archivo txt");

                    break;

                case 5:
                    // Ordenamiento de datos en la estructura de datos
                    // De menor a mayor
                    // Heap sort 
                                                
                    /**Se crea un array para pasar los datos leidos que se almacenaron
                     * en el Arraylist y pasarlo a Array
                     */
                    double[] ArrayListNum = new double[numerosLeidos.size()];     
                    for (int j = 0; j < numerosLeidos.size(); j++) {
                        ArrayListNum[j] = numerosLeidos.get(j); 
                    }

                    // Se instancia la clase y se crea un objeto de tipo App
                    // int longitud = ArrayListNum.length;
                    App proceso = new App();
                    // proceso.sort(ArrayListNum);
                    // Llamamos la funcion de ordenamiento con un parametro
                    proceso.sort(ArrayListNum);
                    // System.out.println("Sorted array is");
                    printArray(ArrayListNum);
                    
                    break;
                default:
                    break;
            } 
            
            // Se finaliza el tiempo de cada funcion que se cumpla 
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

            System.out.println((i)+" ) "+horaTotal+"/"+minutosTotal+"/"+segundosTotal+"/"+milisegundos);
            System.out.println("#################################################");
        }
        // cantidad de numeros generados
        System.out.println("CANTIDAD numeros generados :: "+numerosGene.size());
        // Se vacia el arreglo
        numerosLeidos.clear();
        System.out.println(numerosLeidos);
    }

    // #####################################################################
    // #####################################################################
    /**
     * Metodos para la ordenacion de datos del Arraylist[]
     */
	public void sort(double arrNum[]){

		int longitud = arrNum.length;

		// Construir monticulo (reorganizar la matriz - estructura de datos)
		for (int i = longitud / 2 - 1; i >= 0; i--)
			heapify(arrNum, longitud, i);

		// Uno por uno extrae un elemento del mont??n
		for (int i = longitud - 1; i > 0; i--) {
			// Mover la ra??z actual al final
			double temporal = arrNum[0];
			arrNum[0] = arrNum[i];
			arrNum[i] = temporal;

			// llamar a max heapify en el mont??n reducido
			heapify(arrNum, i, 0);
		}
	}

	// Para apilar un sub??rbol enraizado con el nodo i que es un ??ndice en arr [].
    // n es el tama??o del mont??n
	public static void heapify(double arr[], int n, int i)
	{
		int largest = i; // Inicializar el padre como ra??z (EL mas grande)
		int izquierdo = 2 * i + 1; // Izquierdo = 2*i + 1
		int derecho = 2 * i + 2; // Derecho = 2*i + 2

		// Si el Hijo izquierdo es m??s grande que el padre
		if (izquierdo < n && arr[izquierdo] > arr[largest])
			largest = izquierdo;

		// Si el hijo correcto es m??s grande que el padre hasta ahora
		if (derecho < n && arr[derecho] > arr[largest])
			largest = derecho;

		// Si la m??s grande no es ra??z en numero
		if (largest != i) {
			double intercambio = arr[i];
			arr[i] = arr[largest];
			arr[largest] = intercambio;

			// Hacemos recursividad en el arbol afectado 
			heapify(arr, n, largest);
		}
	}

	/* Se declara funci??n de utilidad para imprimir la los datos de tama??o n */
	public static void printArray(double arr[]){
        System.out.print("Numeros ordenados [");
		int n = arr.length;
		for (int i = 0; i < n; ++i){
            System.out.print(arr[i] + ", "); 
        }
		System.out.println("]");
	}


    // ####################################################################################################
    // ####################################################################################################


    // Funcion que pide cuantos datos requiere el usuario
    public static int cantidadDatosDesee(){
        // Se le pide cuantos datos requiere el usuario
        // Cuantos numeros requeire en aleatorio
        int date = Integer.parseInt(JOptionPane.showInputDialog(null, "??Cuantos datos desea?"));
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
                // Le pasamos 'escribir' ya que linea nos permite escribir ?? 
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
            // PAra poder reescribir en ??l
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
                // Le pasamos 'escribir' ya que linea nos permite escribir ?? 
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