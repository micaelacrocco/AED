/*
 * La declaración “enum” define una clase (llamada tipo enumerado). El cuerpo 
 * de esta clase puede incluir métodos y otros campos. En particular, el 
 * compilador automáticamente agrega algunos métodos especiales cuando crea 
 * un enum. Por ejemplo, tiene un método de valores estáticos que retorna un 
 * array que contiene todos los valores del enum en el orden en que fueron 
 * declarados.
 * 1) Escribe un ejemplo de uso de tal método, y asegúrate de comprender cómo 
 * funciona!!
 * 2) Teniendo presente el programa que tu Equipo escribió para contar vocales 
 * y consonantes en una cierta frase, ¿cómo podrías escribirlo nuevamente 
 * utilizando tipos enumerados?
 */

package ut1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

        // public boolean isVocal(char caracter){
        //     String letra = String.valueOf(caracter).toLowerCase();
        //     if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }

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
                    // for (char letra : letrasLinea) {
                    //     if (IsLetter(letra)) {
                    //         if (isVocal(letra)){
                    //             vocales++;
                    //         } else {
                    //             consonantes++;
                    //         }
                    //     }
                    // }
                    for (char letra : letrasLinea) {
                        if (IsLetter(letra)) {
                            if (isVocal(letra)){
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
            
            int[] resultado = {vocales, consonantes};
            return resultado;
        }

    public static void main(String[] args) {
        ContadorPalabras contador = new ContadorPalabras();
        contador.contarPalabras(
                "C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\ut1_pd5\\src\\main\\java\\ut1\\Entradas\\Si piensas que tu profesor es exige.txt");
        System.out.println(contador.contador);
        
        int[] resultado = contador.contarVocales(
                "C:\\Users\\MICAE\\OneDrive\\Escritorio\\AlgorithmsAndDataStructures\\UT1\\ut1_pd5\\src\\main\\java\\ut1\\Entradas\\Si piensas que tu profesor es exige.txt");
        System.out.println("cant vocales = " + resultado[0] + "\n cant consonantes = " + resultado[1]);
    }
}