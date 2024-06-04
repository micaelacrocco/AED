/*
 * EJERCICIO 2: Parte 2
 * Haz un programa similar al de la parte anterior que devuelva el área y 
 * perímetro de una circunferencia a parGr del radio de la misma.  
 * Los parámetros se deberán leer de stdin. Creando un método estatico llamado
 * “leerEntradaStdin”  en  la  clase  “Principal”  del programa. La firma de 
 * este método será: public static void leerEntradaStdin();"
 */

package ut1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntradaDatosB {
    public static void main(String[] args) {
        leerEntradaStdin("C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\PD6\\entrada2B.txt");
    }

    public static void leerEntradaStdin(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                double radio = Double.parseDouble(linea);
                double area = Math.PI * Math.pow(radio, 2);
                double perimetro = 2 * Math.PI * radio;

                System.out.println("Para un radio de " + radio + ":");
                System.out.println("El área de la circunferencia es: " + area);
                System.out.println("El perímetro de la circunferencia es: " + perimetro);
                System.out.println();
            }

            br.close();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en el archivo: " + e.getMessage());
        }
    }
}
