/*
 * EJERCICIO 1:
 * En este ejercicio se pide una aplicación Swing básica en la cual se ingresa 
 * un nombre y al hacer clic en el botón se muestra un mensaje de saludo. 
 */

package ut1;

import javax.swing.JOptionPane;

public class Greetings {
    private static void greet() {
        String name;
        name = JOptionPane.showInputDialog("Introduce tu nombre: ");
        JOptionPane.showMessageDialog(null, "¡Hola, " + name + "!");
    }
    public static void main(String[] args) {
        greet();
    }
}
