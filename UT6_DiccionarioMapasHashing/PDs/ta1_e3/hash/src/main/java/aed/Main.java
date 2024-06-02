/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        try {
            File archivo1 = new File("C:\\Users\\MICAE\\OneDrive\\Escritorio\\AED\\UT6_DiccionarioMapasHashing\\PDs\\ta1_e3\\hash\\txts\\claves_insertar.txt");
            File archivo2 = new File("C:\\Users\\MICAE\\OneDrive\\Escritorio\\AED\\UT6_DiccionarioMapasHashing\\PDs\\ta1_e3\\hash\\txts\\claves_buscar.txt");
            Scanner lector1 = new Scanner(archivo1);
            Scanner lector2 = new Scanner(archivo2);

            // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"

            int lineas = 0;
            while (lector1.hasNextLine()) {
                lector1.nextLine();
                lineas++;
            }
            lector1.close();

            lector1 = new Scanner(archivo1);
            THash tabla = new THash(lineas);
            while (lector1.hasNextLine()) {
                int clave = Integer.parseInt(lector1.nextLine());
                tabla.insertar(clave);
            }
            lector1.close();

            // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"

            while (lector2.hasNextLine()) {
                int clave = Integer.parseInt(lector2.nextLine());
                tabla.buscar(clave);
            }
            lector2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Ocurrió un error al convertir una línea a número entero.");
            e.printStackTrace();
        }
    }
}
