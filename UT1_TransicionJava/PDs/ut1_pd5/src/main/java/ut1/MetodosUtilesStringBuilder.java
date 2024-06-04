package ut1;

public class MetodosUtilesStringBuilder {
    public static void main(String[] args) {
        // Constructor sin argumentos: crea un StringBuilder con una capacidad inicial de 16 caracteres
        StringBuilder sb1 = new StringBuilder();
        System.out.println("StringBuilder vacío:");
        System.out.println(sb1.toString());

        // Constructor con capacidad inicial especificada
        StringBuilder sb2 = new StringBuilder(20);
        System.out.println("\nStringBuilder con capacidad inicial:");
        System.out.println(sb2.toString());

        // Constructor con cadena inicial
        StringBuilder sb3 = new StringBuilder("Hola");
        System.out.println("\nStringBuilder con cadena inicial:");
        System.out.println(sb3.toString());

        // setLength - establece la longitud de la cadena
        sb3.setLength(3);
        System.out.println("\nsetLength:");
        System.out.println(sb3.toString()); // Imprime "Hol"

        // ensureCapacity - garantiza que la capacidad del StringBuilder sea al menos igual al valor especificado
        sb3.ensureCapacity(10);
        System.out.println("\nensureCapacity:");
        System.out.println(sb3.capacity()); // Imprime "16" o más dependiendo de la implementación

        // append - agrega una cadena o cualquier tipo de datos al final del StringBuilder
        sb3.append(" Mundo");
        System.out.println("\nappend:");
        System.out.println(sb3.toString()); // Imprime "Hol Mundo"

        // insert - inserta una cadena o cualquier tipo de datos en una posición específica del StringBuilder
        sb3.insert(3, "a");
        System.out.println("\ninsert:");
        System.out.println(sb3.toString()); // Imprime "Hola Mundo"

        // delete - elimina una subcadena desde el índice especificado hasta el índice especificado
        sb3.delete(1, 4);
        System.out.println("\ndelete:");
        System.out.println(sb3.toString()); // Imprime "H Mundo"

        // deleteCharAt - elimina el carácter en la posición especificada
        sb3.deleteCharAt(1);
        System.out.println("\ndeleteCharAt:");
        System.out.println(sb3.toString()); // Imprime "Hundo"

        // reverse - invierte el orden de los caracteres en el StringBuilder
        sb3.reverse();
        System.out.println("\nreverse:");
        System.out.println(sb3.toString()); // Imprime "odnuH"
    } 
}


