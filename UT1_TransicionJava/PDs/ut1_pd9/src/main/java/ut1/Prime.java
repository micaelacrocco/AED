/*
 * EJERCICIO 2:
 * Hacer un programa en Java que indique si un número dado es primo. Si lo es, 
 * el programa deberá calcular la suma de los números pares desde 0 hasta el 
 * número dado, y en caso contrario deberá calcular la suma de los números 
 * impares desde 0 hasta el número dado. 
 * Utilizar solamente sentencias while o do-while.
 */

package ut1;

import javax.swing.JOptionPane;

public class Prime {
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static long sumaIsPrime(long n) {
        long sum = 0;
        long i = 0;
        if (isPrime(n)) {
            while (i <= n) {
                if (i % 2 == 0) {
                    sum += i;
                }
                i++;
            }
        } else {
            while (i <= n) {
                if (i % 2 != 0) {
                    sum += i;
                }
                i++;                
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        long numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero."));

        if (isPrime(numero)) {
            JOptionPane.showMessageDialog(null, numero + "es primo.");
            JOptionPane.showMessageDialog(null, "La suma de los números pares desde 0 hasta " + numero + " es: " + sumaIsPrime(numero));
        } else {
            JOptionPane.showMessageDialog(null, numero + "NO es primo.");
            JOptionPane.showMessageDialog(null, "La suma de los números impares desde 0 hasta " + numero + " es: " + sumaIsPrime(numero));
        }
    }
}
