package ut1;
import java.util.Arrays;

public class MetodosUtilesString {
    public static void main(String[] args) {
        String cadena = "Hola Mundo";

        // substring - obtiene una subcadena de la cadena original
        System.out.println("substring:");
        System.out.println(cadena.substring(0, 4)); // Imprime "Hola"

        // split - divide la cadena en partes utilizando un delimitador
        System.out.println("\nsplit:");
        String[] partes = cadena.split(" ");
        System.out.println(Arrays.toString(partes)); // Imprime "[Hola, Mundo]"

        // subSequence - devuelve una secuencia de caracteres dentro de la cadena original
        System.out.println("\nsubSequence:");
        System.out.println(cadena.subSequence(2, 6)); // Imprime "la M"

        // trim - elimina los espacios en blanco al principio y al final de la cadena
        System.out.println("\ntrim:");
        String cadenaConEspacios = "   Hola Mundo   ";
        System.out.println(cadenaConEspacios.trim()); // Imprime "Hola Mundo"

        // toLowerCase - convierte la cadena a minúsculas
        System.out.println("\ntoLowerCase:");
        System.out.println(cadena.toLowerCase()); // Imprime "hola mundo"

        // toUpperCase - convierte la cadena a mayúsculas
        System.out.println("\ntoUpperCase:");
        System.out.println(cadena.toUpperCase()); // Imprime "HOLA MUNDO"

        // indexOf - encuentra la primera aparición de un carácter o una subcadena en la cadena
        System.out.println("\nindexOf:");
        System.out.println(cadena.indexOf('o')); // Imprime "1"
        System.out.println(cadena.indexOf("Mundo")); // Imprime "5"

        // lastIndexOf - encuentra la última aparición de un carácter o una subcadena en la cadena
        System.out.println("\nlastIndexOf:");
        System.out.println(cadena.lastIndexOf('o')); // Imprime "9"
        System.out.println(cadena.lastIndexOf("o", 6)); // Imprime "4"

        // contains - verifica si la cadena contiene una subcadena específica
        System.out.println("\ncontains:");
        System.out.println(cadena.contains("Mundo")); // Imprime "true"

        // replace - reemplaza todas las ocurrencias de un carácter o una subcadena con otra
        System.out.println("\nreplace:");
        System.out.println(cadena.replace('o', 'a')); // Imprime "Hala Munda"
        System.out.println(cadena.replace("Mundo", "World")); // Imprime "Hola World"

        // replaceAll - reemplaza todas las ocurrencias de una expresión regular con otra cadena
        System.out.println("\nreplaceAll:");
        System.out.println(cadena.replaceAll("o", "i")); // Imprime "Hila Mundi"

        // replaceFirst - reemplaza la primera ocurrencia de una expresión regular con otra cadena
        System.out.println("\nreplaceFirst:");
        System.out.println(cadena.replaceFirst("o", "i")); // Imprime "Hila Mundo"
    }   
}
