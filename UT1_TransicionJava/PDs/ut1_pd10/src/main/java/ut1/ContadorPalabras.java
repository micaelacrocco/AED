/*
 * En la clase ContadorPalabras, se desea agregar una función que reciba por 
 * parámetros 2 vectores de palabras (arrays de tipo String) y devuelva otro 
 * vector (array de Strings) conteniendo solamente las palabras que se 
 * encuentren en ambos vectores de entrada. 
 * Por ejemplo:  
 *      Ar1={“Hola”, “mundo”, “de”, “los”, “algoritmos”} 
 *      Ar2={“Hola”, “mundo”, “de”, “la”, “informá ca”} 
 *      arResultado = {“Hola”, “mundo”, “de”} 
 * firma del método de la clase contadorPalabras: 
 * String[] palabrasComunes(String[] palabras1, String[] palabras2) 
 * Trabajo a realizar: 
 *      a) Describir mediante lenguaje natural la nueva funcionalidad. 
 *      b) Desarrollar e implementar el método solicitado. 
 *      c) Dado el archivo de texto de entrada provisto, leer las líneas del 
 * mismo y e invocar al método desarrollado para los vectores de palabras 
 * generados por dos líneas cualesquiera (seleccionadas aleatoriamente). 
 */

package ut1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ContadorPalabras {
    enum Vocal {
        a, e, i, o, u
    }

    public int contador = 0;

    public boolean IsLetter(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }

    public void contarPalabras(String rutaArchivo) {

        boolean isWord = false;
        int palabras = 0;
        try {
            @SuppressWarnings("resource")
            BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
            String linea = bf.readLine();

            while (linea != null) {
                char[] letrasLinea = linea.toCharArray();
                for (char letra : letrasLinea) {
                    if (IsLetter(letra)) {
                        isWord = true;
                    } else {
                        if (isWord) {
                            palabras++;
                            isWord = false;
                        }
                    }
                }
                linea = bf.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato de archivo");
        }
        this.contador = palabras;
    }

    public static boolean isVocal(char letra) {
        letra = Character.toLowerCase(letra);
        for (Vocal vocal : Vocal.values()) {
            if (letra == vocal.name().charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public int[] contarVocales(String rutaArchivo) {
        int vocales = 0;
        int consonantes = 0;

        try {
            @SuppressWarnings("resource")
            BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
            String linea = bf.readLine();

            while (linea != null) {
                char[] letrasLinea = linea.toCharArray();

                for (char letra : letrasLinea) {
                    if (IsLetter(letra)) {
                        if (isVocal(letra)) {
                            vocales++;
                        } else {
                            consonantes++;
                        }
                    }
                }
                linea = bf.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            vocales = -1;
            consonantes = -1;
        } catch (NumberFormatException e) {
            System.err.println("Error de formato de archivo");
            vocales = -1;
            consonantes = -1;
        }

        int[] resultado = { vocales, consonantes };
        return resultado;
    }

    public String[] palabrasComunes(String[] vector1, String[] vector2) {
        ArrayList<String> palabrasComunes = new ArrayList<>();

        Arrays.sort(vector1);
        Arrays.sort(vector2);

        int i = 0;
        int j = 0;
        while (i < vector1.length && j < vector2.length) {
            int comparacion = vector1[i].compareTo(vector2[j]);
            if (comparacion == 0) {
                palabrasComunes.add(vector1[i]);
                i++;
                j++;
            } else if (comparacion < 0) {
                i++;
            } else {
                j++;
            }
        }
        return palabrasComunes.toArray(new String[0]);
    }

    public static void main(String[] args) {
        ContadorPalabras contador = new ContadorPalabras();
    
        // Llamada al método contarPalabras
        contador.contarPalabras("C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\ut1_pd10\\src\\main\\java\\ut1\\Entradas\\Si piensas que tu profesor es exige.txt");
        System.out.println("Cantidad de palabras: " + contador.contador);
    
        // Llamada al método contarVocales
        int[] resultado = contador.contarVocales("C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\ut1_pd10\\src\\main\\java\\ut1\\Entradas\\Si piensas que tu profesor es exige.txt");
        System.out.println("Cantidad de vocales: " + resultado[0] + "\nCantidad de consonantes: " + resultado[1]);
    
        // Llamada al nuevo método palabrasComunes
        String[] vector1 = {"hola", "como", "estas", "ayer"};
        String[] vector2 = {"hola", "estas", "bien", "hoy"};
        String[] palabrasComunes = contador.palabrasComunes(vector1, vector2);
        
        System.out.println("Palabras comunes:");
        for (String palabra : palabrasComunes) {
            System.out.println(palabra);
        }
    }
}
