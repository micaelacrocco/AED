/*
 * EJERCICIO 1:
 * Implementar un método que calcule el factorial de un número entero 
 * cualquiera, siendo este un parámetro del método. Utilizar únicamente 
 * bucles for.
 * Si N=3 entonces factorial(N) = 3.2.1 = 6
 * Una posible firma del método:
 * public static int factorial(int num)
 * {...}
 * NOTA : CONSIDERAR CONDICIONES DE BORDE Y CHEQUEOS DE ERRORES
 */

package ut1;

import javax.swing.JOptionPane;

public class Factorial {
    public static int factorial (int num) {
        int resultado = 1;

        if (num < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
    
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero."));
        JOptionPane.showMessageDialog(null, "El factorial de " + num + " es " + factorial(num) + ".");
    }
}
