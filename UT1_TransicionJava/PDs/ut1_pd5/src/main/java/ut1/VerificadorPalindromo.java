/*
 * EJERCICIO 3:
 *  Analizar el ejercicio sobre “palíndromo”. Introducir el código fuente en 
 * NetBeans y probarlo con diferentes frases. Ver qué sucede al tener letras en 
 * mayúsculas y minúsculas, y algunos símbolos de puntuación como “.”, “,” y 
 * “;”.
 */

package ut1;

import javax.swing.JOptionPane;

public class  VerificadorPalindromo {
    
    public static boolean esPalindromo(String str) {
        // Eliminar espacios en blanco y convertir a minúsculas
        str = str.replaceAll("\\s+", "").toLowerCase();
        
        int izquierda = 0;
        int derecha = str.length() - 1;
        
        while (izquierda < derecha) {
            if (str.charAt(izquierda) != str.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }
    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Ingrese una frase para verificar si es un palíndromo:");
        
        if (entrada != null && !entrada.isEmpty()) {
            if (esPalindromo(entrada)) {
                JOptionPane.showMessageDialog(null, "La frase es un palíndromo.");
            } else {
                JOptionPane.showMessageDialog(null, "La frase no es un palíndromo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se proporcionó ninguna entrada.");
        }
    }
}
