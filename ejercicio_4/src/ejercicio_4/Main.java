
package ejercicio_4;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Cata
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] numeros = new double[6];//creamos el arreglo donde guardaremos los numeros
            
        try {
            //Abrir y leer el archivo
            File archivo = new File("in.txt"); //Cambiar por locación de su archivo
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            //Guardar los 6 numeros en el arreglo
            for(int i = 0; i < 6; i++) {
                numeros[i] = Double.parseDouble(br.readLine());//parsear a Double
            }      
            
        } catch(FileNotFoundException e ) { //Excepcion por si el archivo no se encuentra
            
            System.out.println("No se ha podido leer el archivo");
            
        } catch(IOException ex) { //Excepcion por si hay problemas con el archivo
            
            System.out.println("Hay problemas con su archivo");
        }
        
        //ciclo que ordena de mayor a menor el arreglo de double
        for(int i = 0; i<6; i++){
            
            for(int j= i+1; j<6; j++){
                
                if(numeros[i] < numeros[j]){
                    
                    double aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }        
        }
        
        try{//Ahora escribiremos un nuevo archivo
            
           FileWriter fichero;
           fichero = new FileWriter("out.txt"); //Cambiar por locación de dónde quiere guardar el archivo ordenado
           PrintWriter pw = new PrintWriter(fichero);
           
           //ciclo para guardar los datos en el nuevo archivo
           for(int i = 0; i<6; i++){
               numeros[i] = numeros[i] / 3;//divide por 3 los datos del archivo
               pw.println(numeros[i] + " ");
           }
           
           fichero.close();
           
        }catch(IOException e){//Excepcion por si la creacion del archivo falla
            System.out.println("No se pudo crear el archivo");
        }
    }
    
}
