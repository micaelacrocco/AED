/*
 * EJERCICIO 3: Parte 2
 * Escribe un programa Java que lea de un archivo entrada.txt”, invierta la 
 * entrada, pase a dígitos el texto inverGdo y escriba la salida en salida.txt”. 
 * Creando  un  método  estático  llamado  “transformarT9Texto”  en  la  clase  
 * “Principal”  del programa. La firma de este método será: 
 * public static void transformarT9Texto(String rutaArchivo);
 */

package ut1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EntradaDatosManejoStringB {
    public static void main(String[] args) {
        transformarT9Texto("entrada.txt"); // Cambia el nombre del archivo de entrada según sea necesario
    }

    public static void transformarT9Texto(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/" + rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/salida.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String textoInvertido = invertirTexto(linea);
                String textoT9Invertido = convertirAT9(textoInvertido);
                bw.write(textoT9Invertido);
                bw.newLine();
            }
            System.out.println("La conversión se ha realizado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String invertirTexto(String texto) {
        StringBuilder sb = new StringBuilder(texto);
        return sb.reverse().toString();
    }

    public static String convertirAT9(String texto) {
        texto = texto.toUpperCase(); // Convertir a mayúsculas para asegurar la coincidencia de caracteres
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isAlphabetic(caracter)) {
                if (caracter >= 'A' && caracter <= 'C')
                    resultado.append("2");
                else if (caracter >= 'D' && caracter <= 'F')
                    resultado.append("3");
                else if (caracter >= 'G' && caracter <= 'I')
                    resultado.append("4");
                else if (caracter >= 'J' && caracter <= 'L')
                    resultado.append("5");
                else if (caracter >= 'M' && caracter <= 'O')
                    resultado.append("6");
                else if (caracter >= 'P' && caracter <= 'S')
                    resultado.append("7");
                else if (caracter >= 'T' && caracter <= 'V')
                    resultado.append("8");
                else if (caracter >= 'W' && caracter <= 'Z')
                    resultado.append("9");
            } else if (caracter == ' ')
                resultado.append("0");
            else if (caracter == '.')
                resultado.append("1");
        }
        return resultado.toString();
    }
}
