/*
 * 1) Indica qué es lo que está mal en el siguiente programa.
 * 2) Repara el error, ejecuta el programa y verifica que la salida es correcta.
 */

package ut1;

 public class SomethingIsWrong {
    public static void main(String[] args) {
        // Se crea una instancia de Rectangle 
        Rectangle myRect = new Rectangle();
        
        myRect.width = 40;
        myRect.height = 50;

        System.out.println("myRect's area is " + myRect.area());
    }
}

// El error esta en que el metodo "main" intenta usar un objeto de la clase 
// "Rectangle" sin haberlo instanciado previamente, lo que provoca un error 
// de compilacion.