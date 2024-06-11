package main.java.aed;

import aed.ManejadorArchivosGenerico;
import aed.ManejadorArchivosGenerico2;
import aed.TArbolBB;
import aed.TElementoAB;

public class Main {
    public void main(String[] args) {
        ManejadorArchivosGenerico ManejadorArchivosGenerico = new ManejadorArchivosGenerico();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("UT4_ArbolesBinarios\\PDs\\UT4_PD2\\claves\\arbolesbinarios\\entradas\\claves1.txt");
        TArbolBB<Integer> arbol = new TArbolBB<Integer>();

        for (String linea : lineas) {
            Integer clave = Integer.parseInt(linea); 
            String nombre = Integer.parseInt(linea);
            arbol.insertar(new TElementoAB<Integer>(clave, nombre));
        }

        arbol.buscar(10635);
        arbol.buscar(4567);
        arbol.buscar(12);
        arbol.buscar(8978);

        System.out.println("Preorden: " + arbol.preOrden());
    }
}
