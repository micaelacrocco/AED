/*
 * EJERCICIO 4:
 * 1) Verificar que funciona correctamente e indicar cuál es la salida cuando se invoca con
 * parámetros 13.4 y 66.1
 * 2) ¿cómo debería modificarse el código si los parámetros de línea de comando fueran
 * solamente enteros positivos?
 */

package ut1;

public class ValueOfDemo {
        public static void main(String[] args) {
                // Este programa requiere dos argumentos en la línea de comandos
                if (args.length == 2) {
                        try {
                                // Convertir las cadenas a enteros
                                int a = Integer.parseInt(args[0]);
                                int b = Integer.parseInt(args[1]);

                                // Verificar si ambos enteros son positivos
                                if (a <= 0 || b <= 0) {
                                        throw new IllegalArgumentException(
                                                        "Ambos argumentos deben ser enteros positivos.");
                                }

                                // Realizar operaciones aritméticas
                                System.out.println("a + b = " + (a + b));
                                System.out.println("a - b = " + (a - b));
                                System.out.println("a * b = " + (a * b));
                                System.out.println("a / b = " + (a / b));
                                System.out.println("a % b = " + (a % b));
                        } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida: Por favor, introduce enteros válidos.");
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                } else {
                        System.out.println("Este programa requiere dos argumentos en la línea de comandos.");
                }
        }
}

// Cambios realizados incluyen:
// - Se utiliza Integer.parseInt() para convertir las cadenas de entrada en 
// enteros en lugar de Float.valueOf().
// - Se añade una verificación adicional para asegurar que ambos enteros sean 
// positivos.
// - Se agrega un bloque try-catch para manejar excepciones tanto si las 
// cadenas no pueden ser convertidas en enteros como si los enteros no son positivos.
