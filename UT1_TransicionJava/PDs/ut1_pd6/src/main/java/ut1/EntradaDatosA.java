/*
 * EJERCICIO 2: Parte 1
 * Escribe  un  programa  que  lea  de  un  archivo  !entrada.txt”  e  imprima  la  siguiente  salida  por  consola: 
 * El entero leído es: 12 
 * El número de punto flotante es: 33.44 
 * La cadena leída es “Peter” 
 * ¡Hola Peter! La suma de 12 y 33.44 es 45.44. 
 * La división entera de 33.44 y 12 es 2 y su resto es 9.44. 
 * Contenido del archivo del ejemplo: 
 * 12 
 * 33.44 
 * Peter 
 * Creando  un  método  está/co  llamado  “leerEntradaArchivo”  en  la  clase  “Principal”  del 
 * programa. La firma de este método será: 
 * public sta/c void leerEntradaArchivo(String rutaArchivo); 
 */

package ut1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntradaDatosA {
    public static void main(String[] args) {
        leerEntradaArchivo(
                "C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\PD6\\entrada2A.txt");
    }

    public static void leerEntradaArchivo(String rutaArchivo) {
        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);

            int entero = Integer.parseInt(br.readLine());
            double flotante = Double.parseDouble(br.readLine());
            String cadena = br.readLine();

            br.close();
            fr.close();

            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es \"" + cadena + "\"");
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es "
                    + (entero + flotante) + ".");
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + (int) (flotante / entero)
                    + " y su resto es " + (flotante % entero) + ".");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en el archivo: " + e.getMessage());
        }
    }
}
