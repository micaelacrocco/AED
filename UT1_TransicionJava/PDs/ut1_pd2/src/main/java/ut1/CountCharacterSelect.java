/*
 * EJERCICIO 2:
 * Realiza un JForm.
 * El texto a contar va a ir en donde dice “Esto es una prueba”, al presionar 
 * OK contará las palabras y actualizará la etiqueta “Cantidad de Palabras  50”
 * por el número calculado por su método. 
 * Al seleccionar cada una de las “Opciones”, la aplicación deberá mostrar un 
 * mensaje con la opción seleccionada.
 */

package ut1;

import javax.swing.JOptionPane;

public class CountCharacterSelect {
    static String string;
    static int option;

        public static void countCharacter() {
            string = JOptionPane.showInputDialog("Introduce una cadena de texto: ");

            JOptionPane.showMessageDialog(null, "La cantidad de caracteres es : " + string.length());
        }

        public static void optionSelect() {
            option = JOptionPane.showOptionDialog(null, "Selecione una opcion: ", "Selector de opciones", 
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] 
            { "opcion 1", "opcion 2", "opcion 3" }, null);
    
            JOptionPane.showMessageDialog(null, "La opcion seleccionada es: " + (option + 1));
        }

        public static void main(String[] args) {
            countCharacter();
            optionSelect();
    }
}
