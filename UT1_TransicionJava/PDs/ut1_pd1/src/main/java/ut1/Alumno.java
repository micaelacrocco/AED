/*
 * EJERCICIO 4:
 * a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?
 * b) Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
 * c) Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste? 
 * d) Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste?
 * e) Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste?
 */

package ut1;

 public class Alumno {
    
    private String nombre;

    public Alumno () {
        nombre = null;
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main (String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }

    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 0; i <= cadena.length(); i++) {                
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];   
        return (string[1].charAt(1));
    }

    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        return (String) (x1) ;
    }
}

// -a. El error esta en que todos los metodos deben estar contenidos en una 
// clase, y en este caso hay 4 metodos que no estan contenidos en ninguna clase.

// -b. El error estaba en que el ciclo for de recorrer() estaba mal definido, 
// si se inicializa i en 1, el primer char no se toma en cuenta.

// -c. El error estaba en que el indice mas alto del vector es 7 ya que se 
// comienza a contar en 0.

// -d. El error esta en que se intenta acceder a un elemento vacio del arreglo 
// por lo que al usar el metodo charAt() se produce un error ya que se esta 
// llamando a una cadena nula.

// -e. No es un error tal cual pero no es una forma eficiente de convertir un 
// Integer a String.
