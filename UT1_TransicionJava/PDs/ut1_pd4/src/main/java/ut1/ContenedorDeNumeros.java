/*
 * Dada la siguiente clase, llamada “ContenedorDeNumeros”, escribe un programa 
 * que cree una instancia de la clase, inicialice sus dos variables miembro y
 * luego muestre el valor de cada una de ellas.
 */

package ut1;

public class ContenedorDeNumeros {
    public int anInt;
    public float aFloat;
    public static void main(String[] args) {
        // Creo una instancia de ContenedorDeNumeros.
        ContenedorDeNumeros n = new ContenedorDeNumeros();

        //Inicializo los atributos de la instancia.
        n.anInt = 10;
        n.aFloat = 3.14f;

        // Imprimo los atributos de la instancia.
        System.out.println("anInt: " + n.anInt);
        System.out.println("aFloat: " + n.aFloat);
    }
}
