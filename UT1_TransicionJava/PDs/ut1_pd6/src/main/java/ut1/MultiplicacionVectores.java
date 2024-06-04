/*
 * EJERCICIO 4
 * Escribe un programa Java capaz de realizar la multiplicación de vectores de 
 * Gpo int. Sólamente debe devolver el resultado si los vectores se pueden 
 * mulGplicar. 
 * En lenguaje natural, describe previamente la operación y las condiciones que 
 * deben cumplirse para que sea posible realizarla. 
 */

 package ut1;

 import java.util.Scanner;
 
 public class MultiplicacionVectores {
 
     static Scanner entrada = new Scanner(System.in);
     static int arreglo1[], arreglo2[], arregloFinal[];
     static int nElementos;
 
     /**
      * Este método solicita al usuario la longitud de los vectores y los elementos para llenar los dos vectores.
      * Precondiciones: Ninguna.
      * Postcondiciones: Los vectores arreglo1 y arreglo2 contendrán los elementos ingresados por el usuario.
      */
     public void crearArrays() {
         System.out.println("Ingrese el largo de los vectores: ");
         nElementos = entrada.nextInt();
 
         arreglo1 = new int[nElementos];
         arreglo2 = new int[nElementos];
 
         for (int i = 0; i < nElementos; i++) {
             System.out.println((i + 1) + ". Digite un numero para guardar en el primer array");
             arreglo1[i] = entrada.nextInt();
         }
 
         for (int i = 0; i < nElementos; i++) {
             System.out.println((i + 1) + ". Digite un numero para guardar en el segundo array");
             arreglo2[i] = entrada.nextInt();
         }
     }
 
     /**
      * Este método realiza la multiplicación elemento por elemento de los dos vectores.
      * Precondiciones: Los vectores arreglo1 y arreglo2 deben tener la misma longitud.
      * Postcondiciones: El vector arregloFinal contendrá el resultado de la multiplicación.
      */
     public void multiplicarArrays() {
         arregloFinal = new int[nElementos];
         for (int i = 0; i < nElementos; i++) {
             arregloFinal[i] = arreglo1[i] * arreglo2[i];
         }
     }
 
     /**
      * Este método imprime el resultado de la multiplicación.
      * Precondiciones: El vector arregloFinal debe contener el resultado de la multiplicación.
      * Postcondiciones: El resultado de la multiplicación se muestra en la consola.
      */
     public void imprimirArray() {
         System.out.println("El resultado de la multiplicación de los vectores es:");
         for (int i = 0; i < nElementos; i++) {
             System.out.print(arregloFinal[i] + " ");
         }
     }
 
     public static void main(String[] args) {
         MultiplicacionVectores multiplicador = new MultiplicacionVectores();
         multiplicador.crearArrays();
         multiplicador.multiplicarArrays();
         multiplicador.imprimirArray();
     }
 }
 