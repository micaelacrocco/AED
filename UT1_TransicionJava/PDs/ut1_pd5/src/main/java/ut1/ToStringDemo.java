/*
 * Dado el siguiente código.
 *  1) Indicar cuál es la salida obtenida al ejecutarlo.
 *  2) Indicar por qué se imprime cada uno de los datos y la razón de su forma.
 */

package ut1;

public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
         
        int dot = s.indexOf('.');
         
        System.out.println(dot + " digits " +
            "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
            " digits after decimal point.");
    }
}

// - Salida: 
// 3 digits before decimal point.
// 2 digits after decimal point.

// - Explicación:
// double d = 888.51;: Declara una variable double llamada d e inicializa su 
// valor como 888.51.
// String s = Double.toString(d);: Convierte el valor double de d a un String 
// usando el método toString de la clase Double.
// int dot = s.indexOf('.');: Encuentra la posición del punto decimal en la 
// cadena s.
// System.out.println(dot + " digits " + "before decimal point.");: Imprime la 
// cantidad de dígitos antes del punto decimal. En este caso, la posición del 
// punto es 3 (recordando que la indexación comienza desde 0), por lo que hay 3 
// dígitos antes del punto decimal.
// System.out.println( (s.length() - dot - 1) + " digits after decimal point.")
// ;: Imprime la cantidad de dígitos después del punto decimal. Aquí, 
// s.length() devuelve la longitud total de la cadena s, y s.length() - dot - 1 
// calcula la cantidad de dígitos después del punto, restando la posición del 
// punto y 1 para el punto en sí mismo. En este caso, hay 2 dígitos después del 
// punto decimal.
